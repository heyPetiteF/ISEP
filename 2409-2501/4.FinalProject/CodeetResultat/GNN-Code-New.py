import torch
import torch.nn as nn
import torch.nn.functional as F
from torch_geometric.nn import GCNConv
from torch_geometric.data import Data
from sklearn.preprocessing import MinMaxScaler
import numpy as np
import scipy.io as sio

# Initialize global scalers
longitude_scaler = MinMaxScaler(feature_range=(0, 1))
latitude_scaler = MinMaxScaler(feature_range=(0, 1))

# Data normalization functions (updated for consistency with DNN)
def normalizeX(arr):
    print("\nBefore Normalization (first 10 rows, first 5 columns):")
    print(arr[:10, :5])
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
    longitude_arr = longitude_scaler.fit_transform(longitude_arr.reshape(-1, 1)).flatten()
    latitude_arr = latitude_scaler.fit_transform(latitude_arr.reshape(-1, 1)).flatten()

    print("\nAfter Normalization - Longitude:", longitude_arr[:10])
    print("\nAfter Normalization - Latitude:", latitude_arr[:10])
    return longitude_arr, latitude_arr

def reverse_normalizeY(longitude_arr, latitude_arr):
    global longitude_scaler, latitude_scaler
    longitude_arr = longitude_scaler.inverse_transform(longitude_arr.reshape(-1, 1)).flatten()
    latitude_arr = latitude_scaler.inverse_transform(latitude_arr.reshape(-1, 1)).flatten()

    print("\nAfter Reverse Normalization - Longitude:", longitude_arr[:10])
    print("\nAfter Reverse Normalization - Latitude:", latitude_arr[:10])
    return longitude_arr, latitude_arr

# Define Separate GNN Model (Dropout logic updated)
class SeparateGNNModel(nn.Module):
    def __init__(self, input_dim, hidden_dim, output_dim):
        super(SeparateGNNModel, self).__init__()
        self.mlp = nn.Sequential(
            nn.Linear(input_dim, hidden_dim),
            nn.ELU(),
            nn.Dropout(0.1),  # Adjusted Dropout
            nn.Linear(hidden_dim, hidden_dim),
            nn.ELU(),
            nn.Dropout(0.1)  # Adjusted Dropout
        )
        self.gcn = GCNConv(hidden_dim, hidden_dim)
        self.fc = nn.Linear(hidden_dim, output_dim)

    def forward(self, x, edge_index):
        x = self.mlp(x)
        x = self.gcn(x, edge_index)
        x = F.elu(x)
        x = self.fc(x)
        return x

def build_sparse_edge_index(data, k=5):
    """ Builds k-nearest neighbors graph for sparse edge_index. """
    from sklearn.neighbors import kneighbors_graph
    graph = kneighbors_graph(data, n_neighbors=k, mode='connectivity', include_self=False)
    edge_index = torch.tensor(np.array(graph.nonzero()), dtype=torch.long)
    return edge_index

def train_model(model, train_data, target_indices, n_epochs, lr):
    device = torch.device('cuda' if torch.cuda.is_available() else 'cpu')
    model.to(device)
    optimizer = torch.optim.Adam(model.parameters(), lr=lr)
    loss_fn = nn.MSELoss()

    print("\nTraining Progress:")
    for epoch in range(n_epochs):
        model.train()
        optimizer.zero_grad()

        # Check output dimension and select appropriate targets
        y_hat = model(train_data.x.to(device), train_data.edge_index.to(device))
        if y_hat.shape[1] == 1:  # Single output dimension
            y_hat = y_hat.squeeze()  # Remove channel dimension
            loss = loss_fn(y_hat, train_data.y[:, target_indices].to(device).squeeze())
        else:  # Multi-dimensional output
            y_hat = y_hat[:, target_indices]
            loss = loss_fn(y_hat, train_data.y[:, target_indices].to(device))

        loss.backward()
        optimizer.step()
        print(f"Epoch {epoch + 1}/{n_epochs}, Loss: {loss.item():.6f}")

    return model

def calculate_error(pred, y, floor_penalty=4):
    N = len(y)
    floor_error = np.sqrt(np.square(pred[:, 2] - y[:, 2])).sum()
    longitude_error = np.sqrt(np.square(pred[:, 0] - y[:, 0])).sum()
    latitude_error = np.sqrt(np.square(pred[:, 1] - y[:, 1])).sum()
    coordinates_error_sum = longitude_error + latitude_error
    total_error = floor_penalty * floor_error + coordinates_error_sum
    average_error = total_error / len(y)

    print(f"Sum of Floor Error: {floor_error}")
    print(f"Sum of Coordinates Error: {coordinates_error_sum:.6f}")
    print(f"Total Error: {total_error:.6f}")
    print(f"N:{N}")
    print(f"Average Error in meters: {average_error:.6f}")
    return average_error

if __name__ == '__main__':
    # Test Data
    FILE_PATH = 'C:/Users/16273/GitHub/ISEP-Documents/2409-2501/4.FinalProject/Data/TestData_b0_floor0.mat'
    KEY = 'validationData_building0_floor0'

    mat_data = sio.loadmat(FILE_PATH)
    data = mat_data[KEY]

    x = data[:, :519]
    y = data[:, 519:522]

    x_normalized = normalizeX(x)
    y_normalized_lon, y_normalized_lat = normalizeY(y[:, 0], y[:, 1])
    y_normalized = np.column_stack((y_normalized_lon, y_normalized_lat, y[:, 2]))

    ######################################################## K
    edge_index = build_sparse_edge_index(x_normalized, k=5)

    train_data = Data(
        x=torch.tensor(x_normalized, dtype=torch.float),
        edge_index=edge_index,
        y=torch.tensor(y_normalized, dtype=torch.float)
    )

    ######################################################### EPOCHS
    # Separate models for longitude, latitude, and floor
    print("\nTraining Longitude...")
    model_lon = SeparateGNNModel(input_dim=519, hidden_dim=256, output_dim=1)
    model_lon = train_model(model_lon, train_data, target_indices=[0], n_epochs=3000, lr=0.001)

    print("\nTraining Latitude...")
    model_lat = SeparateGNNModel(input_dim=519, hidden_dim=256, output_dim=1)
    model_lat = train_model(model_lat, train_data, target_indices=[1], n_epochs=3000, lr=0.001)

    print("\nTraining Floor...")
    model_floor = SeparateGNNModel(input_dim=519, hidden_dim=256, output_dim=1)
    model_floor = train_model(model_floor, train_data, target_indices=[2], n_epochs=1000, lr=0.001)

    # Evaluate models
    with torch.no_grad():
        pred_lon = model_lon(train_data.x, train_data.edge_index).cpu().numpy().flatten()
        pred_lat = model_lat(train_data.x, train_data.edge_index).cpu().numpy().flatten()
        pred_floor = torch.round(model_floor(train_data.x, train_data.edge_index)).cpu().numpy().flatten()

        pred_lon, pred_lat = reverse_normalizeY(pred_lon, pred_lat)
        predictions = np.column_stack((pred_lon, pred_lat, pred_floor))

        print("\nPredicted Results (First 10):")
        for i in range(10):
            print(f"Sample {i+1}: Longitude = {pred_lon[i]:.6f}, Latitude = {pred_lat[i]:.6f}, Floor = {int(pred_floor[i])}")

        # Calculate total error and average error
        print("\nResult:")
        predictions[:, 2] = np.round(predictions[:, 2])  # Ensure floors are rounded
        average_error = calculate_error(predictions, y, floor_penalty=4)
        print("Finish.")
