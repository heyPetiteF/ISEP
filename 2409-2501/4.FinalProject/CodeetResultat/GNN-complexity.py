import torch
import torch.nn as nn
import torch.nn.functional as F
from torch_geometric.nn import GCNConv
from torch_geometric.data import Data
from sklearn.preprocessing import MinMaxScaler
import numpy as np
import scipy.io as sio


# Initialize global scalers
longitude_scaler = MinMaxScaler(feature_range=(-1, 1))
latitude_scaler = MinMaxScaler(feature_range=(-1, 1))


# Data normalization functions
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


def reverse_normalizeY(longitude_arr, latitude_arr):
    global longitude_scaler, latitude_scaler
    longitude_arr = longitude_scaler.inverse_transform(longitude_arr.reshape(-1, 1)).flatten()
    latitude_arr = latitude_scaler.inverse_transform(latitude_arr.reshape(-1, 1)).flatten()
    return longitude_arr, latitude_arr


# Define separate GNN models for longitude, latitude, and floor
class SeparateGNNModel(nn.Module):
    def __init__(self, input_dim, hidden_dim, output_dim):
        super(SeparateGNNModel, self).__init__()
        self.mlp = nn.Sequential(
            nn.Linear(input_dim, hidden_dim),
            nn.ELU(),
            nn.Linear(hidden_dim, hidden_dim),
            nn.ELU()
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


def compute_model_complexity(model, input_dim, hidden_dim, output_dim, train_data):
    """
    计算模型的参数数量和 FLOPs，并统一打印输出
    """
    print("\n--- Model Complexity ---")

    # 参数数量计算
    total_params = sum(p.numel() for p in model.parameters() if p.requires_grad)
    print(f"Total Trainable Parameters: {total_params}")

    # FLOPs 计算
    num_nodes = train_data.x.size(0)
    num_edges = train_data.edge_index.size(1)
    # MLP FLOPs
    flops_mlp = (input_dim * hidden_dim + hidden_dim) + (hidden_dim * hidden_dim + hidden_dim)
    # GCN FLOPs
    flops_gcn = 2 * num_edges * hidden_dim + num_nodes * (hidden_dim**2 + hidden_dim)
    # Fully connected FLOPs
    flops_fc = hidden_dim * output_dim + output_dim
    # Total FLOPs
    total_flops = flops_mlp + flops_gcn + flops_fc
    print(f"Estimated FLOPs per forward pass: {total_flops}")

    return {
        "trainable_parameters": total_params,
        "flops_per_forward_pass": total_flops,
    }


if __name__ == '__main__':
    FILE_PATH = 'C:/Users/16273/GitHub/ISEP-Documents/2409-2501/4.FinalProject/Data/TrainingData_b0_floor1.mat'
    KEY = 'trainingData_building0_floor1'

    mat_data = sio.loadmat(FILE_PATH)
    data = mat_data[KEY]

    x = data[:, :519]
    y = data[:, 519:522]

    x_normalized = normalizeX(x)
    y_normalized_lon, y_normalized_lat = normalizeY(y[:, 0], y[:, 1])
    y_normalized = np.column_stack((y_normalized_lon, y_normalized_lat, y[:, 2]))

    edge_index = build_sparse_edge_index(x_normalized, k=15)

    train_data = Data(
        x=torch.tensor(x_normalized, dtype=torch.float),
        edge_index=edge_index,
        y=torch.tensor(y_normalized, dtype=torch.float)
    )

    # Separate models for longitude, latitude, and floor
    print("\nLongitude Model Complexity...")
    complexity_lon = compute_model_complexity(
        model=SeparateGNNModel(input_dim=519, hidden_dim=256, output_dim=1),
        input_dim=519,
        hidden_dim=256,
        output_dim=1,
        train_data=train_data
    )

    print("\nLatitude Model Complexity...")
    complexity_lat = compute_model_complexity(
        model=SeparateGNNModel(input_dim=519, hidden_dim=256, output_dim=1),
        input_dim=519,
        hidden_dim=256,
        output_dim=1,
        train_data=train_data
    )

    print("\nFloor Model Complexity...")
    complexity_floor = compute_model_complexity(
        model=SeparateGNNModel(input_dim=519, hidden_dim=256, output_dim=1),
        input_dim=519,
        hidden_dim=256,
        output_dim=1,
        train_data=train_data
    )

    print("Complexity calculation complete.")
