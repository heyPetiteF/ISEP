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
    #x = data[:, :520]  # RSSI data
    #y = data[:, 520:524]  # Longitude, Latitude, Floor Number, Building Number
    x = np.array(data[:, :520], dtype=float)  # Ensure x is a 2D float array
    y = np.array(data[:, 520:524], dtype=float)  # Ensure y is a 2D float array

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
        
        self.input = Input((520,))
        self.encode_layer = Dense(256, activation='elu')(self.input)
        self.encode_layer = Dense(64, activation='elu')(self.encode_layer)
        decode_layer = Dense(256, activation='elu')(self.encode_layer)
        decode_layer = Dense(520, activation='elu')(decode_layer)
        self.encoder_model = Model(inputs=self.input, outputs=decode_layer)

        longitude_regression_net = Dense(256, activation='elu')(self.encode_layer)
        longitude_regression_net = Dense(128, activation='elu')(longitude_regression_net)
        longitude_regression_net = Dropout(0.5)(longitude_regression_net)
        self.longitude_predict_output = Dense(1)(longitude_regression_net)
        self.longitude_regression_model = Model(inputs=self.input, outputs=self.longitude_predict_output)

        latitude_regression_net = Dense(256, activation='elu')(self.encode_layer)
        latitude_regression_net = Dense(128, activation='elu')(latitude_regression_net)
        latitude_regression_net = Dropout(0.5)(latitude_regression_net)
        self.latitude_predict_output = Dense(1)(latitude_regression_net)
        self.latitude_regression_model = Model(inputs=self.input, outputs=self.latitude_predict_output)

        floor_net = Dense(256, activation='elu')(self.encode_layer)
        floor_net = Dense(128, activation='elu')(floor_net)
        self.floor_predict_output = Dense(1, activation='linear')(floor_net)
        self.floor_model = Model(inputs=self.input, outputs=self.floor_predict_output)

        building_net = Dense(256, activation='elu')(self.encode_layer)
        building_net = Dense(128, activation='elu')(building_net)
        building_net = Dropout(0.5)(building_net)
        self.building_predict_output = Dense(3, activation='softmax')(building_net)
        self.building_model = Model(inputs=self.input, outputs=self.building_predict_output)

    def fit(self, x, y):
        self.normalize_x = normalizeX(x)
        self.longitude_y, self.latitude_y = normalizeY(y[:, 0], y[:, 1])
        self.floorID_y = y[:, 4]
        self.buildingID_y = y[:, 3]  

        self.encoder_model.compile(loss='mse', optimizer='adam')
        self.encoder_model.fit(self.normalize_x, self.normalize_x, epochs=50, batch_size=256)

        for i in range(len(self.encoder_model.layers)):
            self.longitude_regression_model.layers[i].trainable = False
            self.latitude_regression_model.layers[i].trainable = False

        self.longitude_regression_model.compile(loss='mse', optimizer='adam')
        self.latitude_regression_model.compile(loss='mse', optimizer='adam')
        self.longitude_regression_model.fit(self.normalize_x, self.longitude_y, epochs=100, batch_size=256)
        self.latitude_regression_model.fit(self.normalize_x, self.latitude_y, epochs=100, batch_size=256)

        self.floor_model.compile(loss='mse', optimizer='adam')
        self.floor_model.fit(self.normalize_x, self.floorID_y, epochs=50, batch_size=256)

        self.building_model.compile(loss='sparse_categorical_crossentropy', optimizer='adam', metrics=['accuracy'])
        self.building_model.fit(self.normalize_x, self.buildingID_y, epochs=50, batch_size=256)

def predict(self, x):
    x = normalizeX(x)
    
    # Predictions for longitude, latitude, floor, and building
    predict_longitude = self.longitude_regression_model.predict(x)
    predict_latitude = self.latitude_regression_model.predict(x)
    predict_floorID = self.floor_model.predict(x)
    predict_buildingID = np.argmax(self.building_model.predict(x), axis=-1)

    # Print predictions before reverse-normalization
    print("Predict Non-reverse_normalizeY Longitude:", predict_longitude[:10].flatten())
    print("Predict Non-reverse_normalizeY Latitude:", predict_latitude[:10].flatten())
    print("Predict Non-reverse_normalizeY Floor:", predict_floorID[:10].flatten())
    print("Predict Non-reverse_normalizeY Building:", predict_buildingID[:10].flatten())

    # Reverse normalization for longitude and latitude
    predict_longitude, predict_latitude = reverse_normalizeY(predict_longitude, predict_latitude)

    # Adjust floor and building outputs
    predict_longitude = np.expand_dims(predict_longitude, axis=-1)
    predict_latitude = np.expand_dims(predict_latitude, axis=-1)
    predict_floorID = np.round(predict_floorID)
    predict_floorID = np.squeeze(predict_floorID, axis=-1)
    predict_floorID = np.expand_dims(predict_floorID, axis=-1)
    predict_buildingID = np.expand_dims(predict_buildingID, axis=-1)

    # Combine results
    res = np.concatenate((predict_longitude, predict_latitude, predict_floorID, predict_buildingID), axis=1)

    # Print predictions after reverse-normalization
    print("After reverse-normalization:")
    print(res[:10])

    return res

def error(self, x, y, floor_penalty=4, building_penalty=2):
    _y = self.predict(x)

    # Floor error
    floor_error = np.abs(_y[:, 2] - y[:, 2])
    floor_error_sum = np.sum(floor_error)

    # Building error
    building_error = (_y[:, 3] != y[:, 3]).sum() * building_penalty

    # Coordinate errors
    longitude_error = np.sqrt(np.square(_y[:, 0] - y[:, 0]))
    latitude_error = np.sqrt(np.square(_y[:, 1] - y[:, 1]))
    coordinates_error_sum = np.sum(longitude_error + latitude_error)

    # Total error calculation
    total_error = floor_penalty * floor_error_sum + building_error + coordinates_error_sum
    sample_count = len(x)
    average_error = total_error / sample_count

    # Print error summary
    print(f"Sum of Floor Error: {floor_error_sum}")
    print(f"Sum of Building Error: {building_error}")
    print(f"Sum of Coordinates Error: {coordinates_error_sum:.2f}")
    print(f"Total Error: {total_error:.2f}")
    print(f"Average Error per sample: {average_error:.2f} meters")

    return average_error

def compare_floor_predictions(predictions, y_true):
    print(f"{'Line':<5} {'Pre-Longitude':<15} {'Real-Longitude':<15} "
          f"{'Pre-Latitude':<15} {'Real-Latitude':<15} "
          f"{'Pre-Floor':<10} {'Real-Floor':<10} "
          f"{'Pre-Building':<15} {'Real-Building':<15}")
    
    for i in range(len(predictions)):
        pre_longitude, pre_latitude, pre_floor, pre_building = predictions[i]
        real_longitude, real_latitude, real_floor, real_building = y_true[i]
        print(f"{i:<5} {pre_longitude:<15.6f} {real_longitude:<15.6f} "
              f"{pre_latitude:<15.6f} {real_latitude:<15.6f} "
              f"{int(pre_floor):<10} {int(real_floor):<10} "
              f"{int(pre_building):<15} {int(real_building):<15}")
    
if __name__ == '__main__':
    #file = 'C:/Users/16273/GitHub/ISEP-Documents/2409-2501/1.1MachineLearning/Final-Project/Data/trainingData.mat'
    #key = 'trainingData'
    file = 'C:/Users/16273/GitHub/ISEP-Documents/2409-2501/1.1MachineLearning/Final-Project/Data/validationData.mat'
    key = 'validationData'

    x, y = load_data(file, key)

    encode_dnn_model = EncoderDNN()
    encode_dnn_model.fit(x, y)

    predictions = encode_dnn_model.predict(x)
    print("Data predictions:")
    compare_floor_predictions(predictions, y)

    encode_dnn_model.error(x, y)
    print("Finish")
