import scipy.io as sio
import pandas as pd

training_csv = r'C:\Users\16273\GitHub\ISEP-Documents\2409-2501\1.1MachineLearning\Final-Project\Data\trainingData.csv'
validation_csv = r'C:\Users\16273\GitHub\ISEP-Documents\2409-2501\1.1MachineLearning\Final-Project\Data\validationData.csv'

training_data = pd.read_csv(training_csv)
validation_data = pd.read_csv(validation_csv)

mat_data_training = {"trainingData": training_data.to_numpy()}  
mat_data_validation = {"validationData": validation_data.to_numpy()}  

training_mat = r'C:\Users\16273\GitHub\ISEP-Documents\2409-2501\1.1MachineLearning\Final-Project\Data\trainingData.mat'
validation_mat = r'C:\Users\16273\GitHub\ISEP-Documents\2409-2501\1.1MachineLearning\Final-Project\Data\validationData.mat'

sio.savemat(training_mat, mat_data_training)  
sio.savemat(validation_mat, mat_data_validation) 

print(f"Training data saved to {training_mat} with key 'trainingData'.")
print(f"Validation data saved to {validation_mat} with key 'validationData'.")
