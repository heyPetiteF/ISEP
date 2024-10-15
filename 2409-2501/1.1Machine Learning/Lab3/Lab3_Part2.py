import pandas as pd
from sklearn.preprocessing import StandardScaler

# Set the absolute file path for the bankrupt.txt file
file_path = r'C:\Users\16273\GitHub\ISEP-Documents\2409-2501\1.1Machine Learning\Lab3\bankrupt.txt'

# Load the bankrupt dataset using comma as the separator
bankrupt = pd.read_csv(file_path, sep=",")

# Check if the 'Bankrupt?' column exists
correct_column_name = 'Bankrupt?'
if correct_column_name not in bankrupt.columns:
    print(f"Error: '{correct_column_name}' column not found.")
else:
    # Display descriptive statistics for the 'Bankrupt?' column
    print(bankrupt[correct_column_name].describe())

    # Calculate and print the percentage of companies that went bankrupt
    percentage_bankrupt = (bankrupt[correct_column_name].value_counts()[1] / len(bankrupt)) * 100
    print(f"Percentage of companies that went bankrupt: {percentage_bankrupt:.2f}%")

    # Check if the dataset is balanced
    value_counts = bankrupt[correct_column_name].value_counts()
    if abs(value_counts[0] - value_counts[1]) > (0.1 * len(bankrupt)):
        print("The dataset is unbalanced.")
    else:
        print("The dataset is balanced.")

x_train_path = r'C:\Users\16273\GitHub\ISEP-Documents\2409-2501\1.1Machine Learning\Lab3\x_train.csv'
x_test_path = r'C:\Users\16273\GitHub\ISEP-Documents\2409-2501\1.1Machine Learning\Lab3\x_test.csv'
y_train_path = r'C:\Users\16273\GitHub\ISEP-Documents\2409-2501\1.1Machine Learning\Lab3\y_train.csv'
y_test_path = r'C:\Users\16273\GitHub\ISEP-Documents\2409-2501\1.1Machine Learning\Lab3\y_test.csv'

# Load training and testing datasets
x_train = pd.read_csv(x_train_path)
x_test = pd.read_csv(x_test_path)

# Standardize the feature variables
scaler = StandardScaler()
x_train_scaled = pd.DataFrame(scaler.fit_transform(x_train), columns=x_train.columns)
x_test_scaled = pd.DataFrame(scaler.transform(x_test), columns=x_test.columns)

# Verify that the lengths of the standardized dataframes match the original ones
print(f"x_train length: {len(x_train)}, Standardized x_train length: {len(x_train_scaled)}")
print(f"x_test length: {len(x_test)}, Standardized x_test length: {len(x_test_scaled)}")

if {len(x_train)} == {len(x_train_scaled)} and {len(x_test)} == {len(x_test_scaled)}:
    print(f"Standardization success.The length of the training set and the test set are kept consistent")
else: print(f"The length of the training set and the test set are not consistent")