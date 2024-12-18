import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.metrics import mean_squared_error

# Load the dataset
data_train = pd.read_csv('train.txt', sep=';')

# Scatter plot for training data
plt.scatter(data_train['X'], data_train['Y'], color='blue', label='Training Data')
plt.title('Scatter Plot of X and Y (Training Data)')
plt.xlabel('X')
plt.ylabel('Y')
plt.show()

# **************************Polynomial Model Fitting**************************

# Set the polynomial degree - complexity：
degree = 2 

# Fit the polynomial model to the training data
fit = np.polyfit(data_train['X'], data_train['Y'], deg=degree, full=True)

# Extract coefficients and residual sum of squares
coefficients = fit[0]
residual_sum_of_squares = fit[1]

# Print coefficients and residual sum of squares for the selected polynomial degree
print(f"{degree}-degree polynomial coefficients: {coefficients}")
print(f"Residual Sum of Squares: {residual_sum_of_squares}")

# **************************Calculate predictions and plot fitted curve**************************

# Use the fitted model to predict Y values for the training data
Y_pred_train = np.polyval(coefficients, data_train['X'])

# Scatter plot of the data with polynomial fit
plt.scatter(data_train['X'], data_train['Y'], color='blue', label='Training Data')
plt.plot(data_train['X'], Y_pred_train, color='red', label=f'{degree}-degree Polynomial Fit')
plt.title(f'Polynomial Fit (Degree={degree})')
plt.xlabel('X')
plt.ylabel('Y')
plt.legend()
plt.show()

# **************************Calculate RMSE for Training Data**************************

# Calculate RMSE for the training dataset
train_rmse = np.sqrt(mean_squared_error(data_train['Y'], Y_pred_train))
print(f"Training RMSE: {train_rmse}")

# ==========================
# Load Test Dataset and Calculate RMSE
# ==========================
# Load the test data
# Make sure 'test.txt' is in the same directory or provide the full path
data_test = pd.read_csv('test.txt', sep=';')

# Use the same polynomial model to predict Y values for the test data
Y_pred_test = np.polyval(coefficients, data_test['X'])

# Scatter plot of the test data with the polynomial fit
plt.scatter(data_test['X'], data_test['Y'], color='green', label='Test Data')
plt.plot(data_test['X'], Y_pred_test, color='red', label=f'{degree}-degree Polynomial Fit')
plt.title(f'Polynomial Fit on Test Data (Degree={degree})')
plt.xlabel('X')
plt.ylabel('Y')
plt.legend()
plt.show()

# Calculate RMSE for the test dataset
test_rmse = np.sqrt(mean_squared_error(data_test['Y'], Y_pred_test))
print(f"Test RMSE: {test_rmse}")

# **************************Compare RMSE with Different Model Complexity**************************

# Let's compare models with different polynomial degrees (1, 2, 5, 9)
degrees = [1, 2, 5, 9]  # Different degrees of polynomial
train_rmse_list = []  # To store RMSE for training data
test_rmse_list = []   # To store RMSE for test data

# Iterate through different polynomial degrees
for degree in degrees:
    # Fit the polynomial model with the specified degree
    fit = np.polyfit(data_train['X'], data_train['Y'], deg=degree, full=True)
    
    # Predict Y values for the training data
    Y_train_pred = np.polyval(fit[0], data_train['X'])
    train_rmse_list.append(np.sqrt(mean_squared_error(data_train['Y'], Y_train_pred)))
    
    # Predict Y values for the test data
    Y_test_pred = np.polyval(fit[0], data_test['X'])
    test_rmse_list.append(np.sqrt(mean_squared_error(data_test['Y'], Y_test_pred)))

# Plot RMSE vs Model Complexity
plt.plot(degrees, train_rmse_list, 'bo-', label='Training RMSE')
plt.plot(degrees, test_rmse_list, 'ro-', label='Test RMSE')
plt.title('RMSE vs Model Complexity (Degree of Polynomial)')
plt.xlabel('Model Complexity (Degree)')
plt.ylabel('RMSE')
plt.legend()
plt.show()
