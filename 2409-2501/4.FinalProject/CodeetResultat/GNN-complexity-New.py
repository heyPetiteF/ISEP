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

# Define Separate GNN Model
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

def compute_model_complexity(model, input_dim, hidden_dim, output_dim, train_data):
    """
    Compute model's parameter count and FLOPs.
    """
    # Parameter count
    total_params = sum(p.numel() for p in model.parameters() if p.requires_grad)

    # FLOPs calculation
    num_nodes = train_data.x.size(0)
    num_edges = train_data.edge_index.size(1)
    flops_mlp = (input_dim * hidden_dim + hidden_dim) + (hidden_dim * hidden_dim + hidden_dim)
    flops_gcn = 2 * num_edges * hidden_dim + num_nodes * (hidden_dim**2 + hidden_dim)
    flops_fc = hidden_dim * output_dim + output_dim
    total_flops = flops_mlp + flops_gcn + flops_fc

    return {
        "parameters": total_params,
        "flops": total_flops,
    }

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

    # Build edge index
    edge_index = build_sparse_edge_index(x_normalized, k=5)

    train_data = Data(
        x=torch.tensor(x_normalized, dtype=torch.float),
        edge_index=edge_index,
        y=torch.tensor(y_normalized, dtype=torch.float)
    )

    # Initialize complexity accumulators
    total_params = 0
    total_flops = 0

    print("\n--- Model Complexity ---")

    # Calculate and print model complexity for each task
    model_lon = SeparateGNNModel(input_dim=519, hidden_dim=256, output_dim=1)
    complexity_lon = compute_model_complexity(
        model=model_lon,
        input_dim=519,
        hidden_dim=256,
        output_dim=1,
        train_data=train_data
    )
    print(f"Longitude Model: Parameters = {complexity_lon['parameters']}, FLOPs = {complexity_lon['flops']}")
    total_params += complexity_lon["parameters"]
    total_flops += complexity_lon["flops"]

    model_lat = SeparateGNNModel(input_dim=519, hidden_dim=256, output_dim=1)
    complexity_lat = compute_model_complexity(
        model=model_lat,
        input_dim=519,
        hidden_dim=256,
        output_dim=1,
        train_data=train_data
    )
    print(f"Latitude Model: Parameters = {complexity_lat['parameters']}, FLOPs = {complexity_lat['flops']}")
    total_params += complexity_lat["parameters"]
    total_flops += complexity_lat["flops"]

    model_floor = SeparateGNNModel(input_dim=519, hidden_dim=256, output_dim=1)
    complexity_floor = compute_model_complexity(
        model=model_floor,
        input_dim=519,
        hidden_dim=256,
        output_dim=1,
        train_data=train_data
    )
    print(f"Floor Model: Parameters = {complexity_floor['parameters']}, FLOPs = {complexity_floor['flops']}")
    total_params += complexity_floor["parameters"]
    total_flops += complexity_floor["flops"]

    # Print Overall Complexity
    print(f"\nOverall Model Complexity: Parameters = {total_params}, FLOPs = {total_flops}")
    print("Finish.")
