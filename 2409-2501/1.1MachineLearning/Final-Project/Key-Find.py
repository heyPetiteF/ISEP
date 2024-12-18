import scipy.io as sio

# Key Name
train_file = 'C:/Users/16273/GitHub/ISEP-Documents/2409-2501/1.1Machine Learning/Final-Project/Data/trainingData.mat'
mat_data1 = sio.loadmat(train_file)

test_file = 'C:/Users/16273/GitHub/ISEP-Documents/2409-2501/1.1Machine Learning/Final-Project/Data/validationData.mat'
mat_data2 = sio.loadmat(test_file)

print(f"\nThe trainingData keys:\n{mat_data1.keys()}")
print(f"\nThe testData keys:\n{mat_data2.keys()}")