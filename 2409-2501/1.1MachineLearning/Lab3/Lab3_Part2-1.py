# Import necessary libraries
import pandas as pd
from sklearn.tree import DecisionTreeClassifier, plot_tree
from sklearn.metrics import confusion_matrix, classification_report
from sklearn.metrics import balanced_accuracy_score
import matplotlib.pyplot as plt
import numpy as np

x_train = pd.read_csv('C:\\Users\\16273\\GitHub\\ISEP-Documents\\2409-2501\\1.1Machine Learning\\Lab3\\x_train.csv')
x_test = pd.read_csv('C:\\Users\\16273\\GitHub\\ISEP-Documents\\2409-2501\\1.1Machine Learning\\Lab3\\x_test.csv')
y_train = pd.read_csv('C:\\Users\\16273\\GitHub\\ISEP-Documents\\2409-2501\\1.1Machine Learning\\Lab3\\y_train.csv', usecols=['Bankrupt']).squeeze()
y_test = pd.read_csv('C:\\Users\\16273\\GitHub\\ISEP-Documents\\2409-2501\\1.1Machine Learning\\Lab3\\y_test.csv', usecols=['Bankrupt']).squeeze()

# -----------------------------------------2.1-1-----------------------------------------#
# Fit a classification tree of maximum depth 3
class_tree_bankrupt = DecisionTreeClassifier(max_depth=3, random_state=1)
class_tree_bankrupt.fit(x_train, y_train)

# Plot the decision tree
plt.figure(figsize=(20, 10))
plot_tree(class_tree_bankrupt, feature_names=x_train.columns, filled=True, class_names=True)
plt.show()

# Get the number of terminal nodes (leaves)
num_leaves = class_tree_bankrupt.get_n_leaves()
print(f"Number of terminal nodes (leaves): {num_leaves}")

# Create a new company data with specific financial features and fill the rest with zeros
new_company_complete = pd.DataFrame([[0]*10 + [-1.73, 0.50, 0.75]], columns=x_train.columns)

# Predict whether the new company will go bankrupt
prediction = class_tree_bankrupt.predict(new_company_complete)

# Print the prediction array for debugging
print(f"Raw prediction array: {prediction}")

# Access the first element of the prediction and print result
prediction_value = prediction[0]
print(f"Prediction for the new company: {'Bankrupt' if prediction_value == 1 else 'Not Bankrupt'}")


# -----------------------------------------2.1-2-----------------------------------------#
# Make predictions for train and test sets
y_train_pred = class_tree_bankrupt.predict(x_train)
y_test_pred = class_tree_bankrupt.predict(x_test)

# Calculate and print the confusion matrix and classification report for the training set
print("\nTraining Set Confusion Matrix:")
print(confusion_matrix(y_train, y_train_pred))
print("\nTraining Set Classification Report:")
print(classification_report(y_train, y_train_pred))

# Calculate and print the confusion matrix and classification report for the test set
print("\nTest Set Confusion Matrix:")
print(confusion_matrix(y_test, y_test_pred))
print("\nTest Set Classification Report:")
print(classification_report(y_test, y_test_pred))

# -----------------------------------------2.1-c-----------------------------------------#
# Step a
prun_tree_bankrupt = DecisionTreeClassifier(random_state=10)
path = prun_tree_bankrupt.cost_complexity_pruning_path(x_train, y_train)
alphas, impurities = path.ccp_alphas, path.impurities

# Step b
class_tree_bankrupt_list = []
for alpha in alphas:
    clf = DecisionTreeClassifier(random_state=10, ccp_alpha=alpha)
    clf.fit(x_train, y_train)
    class_tree_bankrupt_list.append(clf)

# Remove the last element from the list (trivial classifier)
class_tree_bankrupt_list = class_tree_bankrupt_list[:-1]
alphas = alphas[:-1]

# Step c
train_balanced_acc = []
test_balanced_acc = []

for clf in class_tree_bankrupt_list:
    # Calculate balanced accuracy for train and test sets
    y_train_pred = clf.predict(x_train)
    y_test_pred = clf.predict(x_test)
    train_balanced_acc.append(balanced_accuracy_score(y_train, y_train_pred))
    test_balanced_acc.append(balanced_accuracy_score(y_test, y_test_pred))

# Plot the results
plt.figure(figsize=(10, 6))
plt.plot(alphas, train_balanced_acc, label='Train Balanced Accuracy')
plt.plot(alphas, test_balanced_acc, label='Test Balanced Accuracy')
plt.xlabel('Alpha')
plt.ylabel('Balanced Accuracy')
plt.title('Train and Test Balanced Accuracy vs Alpha')
plt.legend()
plt.show()

# Find the best alpha (the one with the highest test balanced accuracy)
best_alpha_index = np.argmax(test_balanced_acc)
best_alpha = alphas[best_alpha_index]
best_tree = class_tree_bankrupt_list[best_alpha_index]

print(f"Best alpha value: {best_alpha}")

# Get the number of leaves in the chosen tree
num_leaves_best_tree = best_tree.get_n_leaves()
print(f"Number of leaves in the chosen tree: {num_leaves_best_tree}")

# -----------------------------------------2.1-d-----------------------------------------#
# Use the best tree (from part c) for prediction on train and test data
y_train_pred_best = best_tree.predict(x_train)
y_test_pred_best = best_tree.predict(x_test)

# Calculate and print confusion matrix and classification report for training set
print("Training Set Confusion Matrix (Best Classifier):")
print(confusion_matrix(y_train, y_train_pred_best))
print("\nTraining Set Classification Report (Best Classifier):")
print(classification_report(y_train, y_train_pred_best))

# Calculate and print confusion matrix and classification report for test set
print("\nTest Set Confusion Matrix (Best Classifier):")
print(confusion_matrix(y_test, y_test_pred_best))
print("\nTest Set Classification Report (Best Classifier):")
print(classification_report(y_test, y_test_pred_best))