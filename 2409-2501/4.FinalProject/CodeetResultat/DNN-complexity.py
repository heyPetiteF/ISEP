import scipy.io as sio
import numpy as np
from sklearn.preprocessing import MinMaxScaler
from keras.layers import Dense, Input, Dropout
from keras.models import Model

# Initialize global scalers
longitude_scaler = MinMaxScaler()
latitude_scaler = MinMaxScaler()

def load_data(file, key):
    mat_data = sio.loadmat(file)

    if key in mat_data:
        data = mat_data[key]
    else:
        raise KeyError(f"Cannot find key '{key}' in the .mat file: {file}")

    # Split data into RSSI and location data
    x = data[:, :519]  # RSSI data
    y = data[:, 519:522]  # Longitude, Latitude, Floor Number

    print("The first 10 data samples:")
    for i in range(10):
        rssi_values = "\t".join([f"{x[i, j]:.1f}" for j in range(5)])
        longitude, latitude, floor = y[i]
        print(f"{rssi_values}\t{longitude:.6f}\t{latitude:.6f}\t{int(floor)}")

    return x, y

def normalizeX(arr):
    """
    Custom normalization for RSSI data.
    """
    print("\nBefore Normalization (first 10 rows, first 5 columns):")
    print(arr[:10, :5])

    # Scale RSSI data linearly to the range [0, 1]
    arr = np.copy(arr)
    min_val, max_val = np.min(arr), np.max(arr)
    arr = (arr - min_val) / (max_val - min_val)

    print("\nAfter Normalization (first 10 rows, first 5 columns):")
    print(arr[:10, :5])

    return arr

def normalizeY(longitude_arr, latitude_arr):

    print("\nBefore Normalization - Longitude:", longitude_arr[:10])
    print("\nBefore Normalization - Latitude:", latitude_arr[:10])

    global longitude_scaler, latitude_scaler
    longitude_arr = np.reshape(longitude_arr, [-1, 1])
    latitude_arr = np.reshape(latitude_arr, [-1, 1])

    normalized_longitude = longitude_scaler.fit_transform(longitude_arr).flatten()
    normalized_latitude = latitude_scaler.fit_transform(latitude_arr).flatten()

    print("\nAfter Normalization - Longitude:", normalized_longitude[:10])
    print("\nAfter Normalization - Latitude:", normalized_latitude[:10])

    return normalized_longitude, normalized_latitude

def reverse_normalizeY(longitude_arr, latitude_arr=None):

    global longitude_scaler, latitude_scaler
    longitude_arr = np.reshape(longitude_arr, [-1, 1])
    latitude_arr = np.reshape(latitude_arr, [-1, 1])

    reversed_longitude = longitude_scaler.inverse_transform(longitude_arr).flatten()
    reversed_latitude = latitude_scaler.inverse_transform(latitude_arr).flatten()

    print("\nAfter Reverse Normalization - Longitude:", reversed_longitude[:10])
    print("\nAfter Reverse Normalization - Latitude:", reversed_latitude[:10])

    return reversed_longitude, reversed_latitude

class EncoderDNN:
    def __init__(self):
        
        self.input = Input((519,))
        self.encode_layer = Dense(256, activation='elu')(self.input)
        self.encode_layer = Dense(64, activation='elu')(self.encode_layer)
        decode_layer = Dense(256, activation='elu')(self.encode_layer)
        decode_layer = Dense(519, activation='elu')(decode_layer)
        self.encoder_model = Model(inputs=self.input, outputs=decode_layer)

        longitude_regression_net = Dense(256, activation='elu')(self.encode_layer)
        longitude_regression_net = Dense(128, activation='elu')(longitude_regression_net)
        longitude_regression_net = Dropout(0.5)(longitude_regression_net)
        longitude_regression_net = Dense(128, activation='elu')(longitude_regression_net)
        longitude_regression_net = Dropout(0.5)(longitude_regression_net)
        longitude_regression_net = Dense(64, activation='elu')(longitude_regression_net)
        longitude_regression_net = Dense(64, activation='elu')(longitude_regression_net)
        self.longitude_predict_output = Dense(1)(longitude_regression_net)
        self.longitude_regression_model = Model(inputs=self.input, outputs=self.longitude_predict_output)

        latitude_regression_net = Dense(256, activation='elu')(self.encode_layer)
        latitude_regression_net = Dense(128, activation='elu')(latitude_regression_net)
        latitude_regression_net = Dropout(0.5)(latitude_regression_net)
        latitude_regression_net = Dense(128, activation='elu')(latitude_regression_net)
        latitude_regression_net = Dropout(0.5)(latitude_regression_net)
        latitude_regression_net = Dense(64, activation='elu')(latitude_regression_net)
        latitude_regression_net = Dense(64, activation='elu')(latitude_regression_net)
        self.latitude_predict_output = Dense(1)(latitude_regression_net)
        self.latitude_regression_model = Model(inputs=self.input, outputs=self.latitude_predict_output)

        floor_net = Dense(256, activation='elu')(self.encode_layer)
        floor_net = Dense(128, activation='elu')(floor_net)
        self.floor_predict_output = Dense(1, activation='linear')(floor_net)
        self.floor_model = Model(inputs=self.input, outputs=self.floor_predict_output)

    def compute_dnn_complexity(self):
        def model_complexity(model):
            total_params = model.count_params()
            return total_params

        print("\n--- Model Complexity ---")
        encoder_total = model_complexity(self.encoder_model)
        print(f"Encoder Model: Total Parameters: {encoder_total}")

        longitude_total = model_complexity(self.longitude_regression_model)
        print(f"Longitude Regression Model: Total Parameters: {longitude_total}")

        latitude_total = model_complexity(self.latitude_regression_model)
        print(f"Latitude Regression Model: Total Parameters: {latitude_total}")

        floor_total = model_complexity(self.floor_model)
        print(f"Floor Prediction Model: Total Parameters: {floor_total}")

        grand_total = encoder_total + longitude_total + latitude_total + floor_total
        print(f"\nOverall Model Complexity: Total Parameters: {grand_total}")


    def fit(self, x, y):
        self.normalize_x = normalizeX(x)
        self.longitude_y, self.latitude_y = normalizeY(y[:, 0], y[:, 1])
        self.floorID_y = y[:, 2]

        self.encoder_model.compile(loss='mse', optimizer='adam')
        self.encoder_model.fit(self.normalize_x, self.normalize_x, epochs=50, batch_size=64)

        for i in range(len(self.encoder_model.layers)):
            self.longitude_regression_model.layers[i].trainable = False
            self.latitude_regression_model.layers[i].trainable = False

        self.longitude_regression_model.compile(loss='mse', optimizer='adam')
        self.latitude_regression_model.compile(loss='mse', optimizer='adam')
        self.longitude_regression_model.fit(self.normalize_x, self.longitude_y, epochs=3000, batch_size=64)
        self.latitude_regression_model.fit(self.normalize_x, self.latitude_y, epochs=3000, batch_size=64)

        self.floor_model.compile(loss='mse', optimizer='adam')
        self.floor_model.fit(self.normalize_x, self.floorID_y, epochs=1000, batch_size=64)

    def predict(self, x):
        x = normalizeX(x)
        predict_longitude = self.longitude_regression_model.predict(x)
        predict_latitude = self.latitude_regression_model.predict(x)
        predict_floorID = self.floor_model.predict(x)

        print("Predict Non-reverse_normalizeY Longitude:", predict_longitude[:10].flatten())
        print("Predict Non-reverse_normalizeY Latitude:", predict_latitude[:10].flatten())
        print("Predict Non-reverse_normalizeY Floor:", predict_floorID[:10].flatten())

        predict_longitude, predict_latitude = reverse_normalizeY(predict_longitude, predict_latitude)

        predict_longitude = np.expand_dims(predict_longitude, axis=-1)
        predict_latitude = np.expand_dims(predict_latitude, axis=-1)
        predict_floorID = np.round(predict_floorID)
        predict_floorID = np.squeeze(predict_floorID, axis=-1)
        predict_floorID = np.expand_dims(predict_floorID, axis=-1)

        res = np.concatenate((predict_longitude, predict_latitude, predict_floorID), axis=1)

        print("After reverse-normalization:")
        print(res[:10])

        return res

    def error(self, x, y, floor_penalty=4):
        _y = self.predict(x)

        floor_error = np.sqrt(np.square(_y[:, 2] - y[:, 2]))
        floor_error_sum = np.sum(floor_error)

        longitude_error = np.sqrt(np.square(_y[:, 0] - y[:, 0]))
        latitude_error = np.sqrt(np.square(_y[:, 1] - y[:, 1]))
        coordinates_error_sum = np.sum(longitude_error + latitude_error)

        total_error = floor_penalty * floor_error_sum + coordinates_error_sum
        sample_count = len(x)
        average_error = total_error / sample_count

        print(f"Sum of Floor Error: {floor_error_sum}")
        # Sum of Coordinates Error (Longitude + Latitude)
        print(f"Sum of Coordinates Error : {coordinates_error_sum}")
        # Total Error (Longitude + Latitude + Floor Error)
        print(f"Total Error : {total_error}")
        # Sample Count (Total Floors)
        print(f"N: {sample_count}")
        print(f"Average Error in meters: {average_error:.2f}")

        return average_error

def compare_floor_predictions(predictions, y_true):
    print(f"{'Line':<5} {'Pre-Longitude':<15} {'Real-Longitude':<15} {'Pre-Latitude':<15} {'Real-Latitude':<15} {'Pre-Floor':<10} {'Real-Floor':<10}")
    for i in range(len(predictions)):
        pre_longitude, pre_latitude, pre_floor = predictions[i]
        real_longitude, real_latitude, real_floor = y_true[i]
        print(f"\n{i:<5} {pre_longitude:<15.6f} {real_longitude:<15.6f} {pre_latitude:<15.6f} {real_latitude:<15.6f} {int(pre_floor):<10} {int(real_floor):<10}")

if __name__ == '__main__':
    #file = 'C:/Users/16273/GitHub/ISEP-Documents/2409-2501/4.FinalProject/Data/TrainingData_b0.mat'
    #key = 'trainingData_building0'
    file = 'C:/Users/16273/GitHub/ISEP-Documents/2409-2501/4.FinalProject/Data/TestData_b0_floor1.mat'
    key = 'validationData_building0_floor1'

    x, y = load_data(file, key)

    encode_dnn_model = EncoderDNN()
    encode_dnn_model.fit(x, y)

    predictions = encode_dnn_model.predict(x)
    print("Data predictions:")
    compare_floor_predictions(predictions, y)

    encode_dnn_model.error(x, y)

    encode_dnn_model.compute_dnn_complexity()
    print("Finish")
