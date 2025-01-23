import numpy as np
from sklearn.preprocessing import MinMaxScaler
from keras.layers import Dense, Input, Dropout
from keras.models import Model
import scipy.io as sio

# Initialize global scalers
longitude_scaler = MinMaxScaler()
latitude_scaler = MinMaxScaler()

def load_data(file, key):
    mat_data = sio.loadmat(file)
    if key in mat_data:
        data = mat_data[key]
    else:
        raise KeyError(f"Cannot find key '{key}' in the .mat file: {file}")
    x = data[:, :519]  # RSSI data
    y = data[:, 519:522]  # Longitude, Latitude, Floor Number
    return x, y

def normalizeX(arr):
    arr = np.copy(arr)
    min_val, max_val = np.min(arr), np.max(arr)
    arr = (arr - min_val) / (max_val - min_val)
    return arr

def normalizeY(longitude_arr, latitude_arr):
    global longitude_scaler, latitude_scaler
    longitude_arr = longitude_scaler.fit_transform(longitude_arr.reshape(-1, 1)).flatten()
    latitude_arr = latitude_scaler.fit_transform(latitude_arr.reshape(-1, 1)).flatten()
    return longitude_arr, latitude_arr

class EncoderDNN:
    def __init__(self):
        self.input = Input((519,))
        self.encode_layer = Dense(256, activation='elu')(self.input)
        self.encode_layer = Dense(64, activation='elu')(self.encode_layer)
        decode_layer = Dense(256, activation='elu')(self.encode_layer)
        decode_layer = Dense(519, activation='elu')(decode_layer)
        self.encoder_model = Model(inputs=self.input, outputs=decode_layer)

        longitude_net = Dense(256, activation='elu')(self.encode_layer)
        longitude_net = Dense(128, activation='elu')(longitude_net)
        longitude_net = Dropout(0.5)(longitude_net)
        longitude_net = Dense(128, activation='elu')(longitude_net)
        longitude_net = Dropout(0.5)(longitude_net)
        longitude_net = Dense(64, activation='elu')(longitude_net)
        self.longitude_predict_output = Dense(1)(longitude_net)
        self.longitude_model = Model(inputs=self.input, outputs=self.longitude_predict_output)

        latitude_net = Dense(256, activation='elu')(self.encode_layer)
        latitude_net = Dense(128, activation='elu')(latitude_net)
        latitude_net = Dropout(0.5)(latitude_net)
        latitude_net = Dense(128, activation='elu')(latitude_net)
        latitude_net = Dropout(0.5)(latitude_net)
        latitude_net = Dense(64, activation='elu')(latitude_net)
        self.latitude_predict_output = Dense(1)(latitude_net)
        self.latitude_model = Model(inputs=self.input, outputs=self.latitude_predict_output)

        floor_net = Dense(256, activation='elu')(self.encode_layer)
        floor_net = Dense(128, activation='elu')(floor_net)
        self.floor_predict_output = Dense(1, activation='linear')(floor_net)
        self.floor_model = Model(inputs=self.input, outputs=self.floor_predict_output)

    def compute_model_complexity(self, input_dim):
        """
        Computes total trainable parameters and FLOPs for all DNN models.
        Output is formatted to match GNN complexity output.
        """
        def compute_params_and_flops(model):
            total_params = model.count_params()
            total_flops = 0
            for layer in model.layers:
                if isinstance(layer, Dense):
                    weights = layer.get_weights()
                    if weights:  # Ensure weights are initialized
                        input_units, output_units = weights[0].shape
                        total_flops += input_units * output_units + output_units  # Multiply-Adds
            return total_params, total_flops

        print("\n--- Model Complexity ---")
        encoder_params, encoder_flops = compute_params_and_flops(self.encoder_model)
        print(f"Encoder Model: Parameters = {encoder_params}, FLOPs = {encoder_flops}")

        longitude_params, longitude_flops = compute_params_and_flops(self.longitude_model)
        print(f"Longitude Model: Parameters = {longitude_params}, FLOPs = {longitude_flops}")

        latitude_params, latitude_flops = compute_params_and_flops(self.latitude_model)
        print(f"Latitude Model: Parameters = {latitude_params}, FLOPs = {latitude_flops}")

        floor_params, floor_flops = compute_params_and_flops(self.floor_model)
        print(f"Floor Model: Parameters = {floor_params}, FLOPs = {floor_flops}")

        total_params = encoder_params + longitude_params + latitude_params + floor_params
        total_flops = encoder_flops + longitude_flops + latitude_flops + floor_flops

        print(f"\nOverall Model Complexity: Parameters = {total_params}, FLOPs = {total_flops}")
        return {"parameters": total_params, "flops": total_flops}

    def fit(self, x, y):
        self.normalize_x = normalizeX(x)
        self.longitude_y, self.latitude_y = normalizeY(y[:, 0], y[:, 1])
        self.floor_y = y[:, 2]

        self.encoder_model.compile(optimizer='adam', loss='mse')
        self.encoder_model.fit(self.normalize_x, self.normalize_x, epochs=50, batch_size=64)

        self.longitude_model.compile(optimizer='adam', loss='mse')
        self.longitude_model.fit(self.normalize_x, self.longitude_y, epochs=1000, batch_size=64)

        self.latitude_model.compile(optimizer='adam', loss='mse')
        self.latitude_model.fit(self.normalize_x, self.latitude_y, epochs=1000, batch_size=64)

        self.floor_model.compile(optimizer='adam', loss='mse')
        self.floor_model.fit(self.normalize_x, self.floor_y, epochs=500, batch_size=64)

if __name__ == '__main__':
    file = 'C:/Users/16273/GitHub/ISEP-Documents/2409-2501/4.FinalProject/Data/TestData_b0_floor1.mat'
    key = 'validationData_building0_floor1'
    x, y = load_data(file, key)

    model = EncoderDNN()

    # 使用 build() 初始化模型
    input_dim = x.shape[1]
    model.encoder_model.build(input_shape=(None, input_dim))
    model.longitude_model.build(input_shape=(None, input_dim))
    model.latitude_model.build(input_shape=(None, input_dim))
    model.floor_model.build(input_shape=(None, input_dim))

    # 计算复杂度
    complexity = model.compute_model_complexity(input_dim=input_dim)
    print(f"DNN Complexity: Parameters = {complexity['parameters']}, FLOPs = {complexity['flops']}")
    print("Finish")
