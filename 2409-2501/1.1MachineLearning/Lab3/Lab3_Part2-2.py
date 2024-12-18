# Import necessary libraries
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from sklearn.ensemble import RandomForestClassifier,AdaBoostClassifier
from sklearn.metrics import confusion_matrix, classification_report

x_train = pd.read_csv('C:\\Users\\16273\\GitHub\\ISEP-Documents\\2409-2501\\1.1Machine Learning\\Lab3\\x_train.csv')
x_test = pd.read_csv('C:\\Users\\16273\\GitHub\\ISEP-Documents\\2409-2501\\1.1Machine Learning\\Lab3\\x_test.csv')
y_train = pd.read_csv('C:\\Users\\16273\\GitHub\\ISEP-Documents\\2409-2501\\1.1Machine Learning\\Lab3\\y_train.csv', usecols=['Bankrupt']).squeeze()
y_test = pd.read_csv('C:\\Users\\16273\\GitHub\\ISEP-Documents\\2409-2501\\1.1Machine Learning\\Lab3\\y_test.csv', usecols=['Bankrupt']).squeeze()

# -------------------------------------2.2-1-------------------------------------#
# Initialize RandomForestClassifier for Bagging (max_features = 12 for all predictors)
bagging_bankrupt = RandomForestClassifier(max_features=12, random_state=1)

# Fit the model on the training data
bagging_bankrupt.fit(x_train, np.ravel(y_train))

# Make predictions for train and test sets
y_train_pred_bagging = bagging_bankrupt.predict(x_train)
y_test_pred_bagging = bagging_bankrupt.predict(x_test)

print("-------------------------------------2.2-1-------------------------------------")

# Evaluate the model on training data
print("Training Set Confusion Matrix (Bagging):")
print(confusion_matrix(y_train, y_train_pred_bagging))
print("\nTraining Set Classification Report (Bagging):")
print(classification_report(y_train, y_train_pred_bagging))

# Evaluate the model on test data
print("\nTest Set Confusion Matrix (Bagging):")
print(confusion_matrix(y_test, y_test_pred_bagging))
print("\nTest Set Classification Report (Bagging):")
print(classification_report(y_test, y_test_pred_bagging))
  
# -------------------------------------2.2-2-------------------------------------#
# Initialize RandomForestClassifier for Random Forest (max_features = 'sqrt' for sqrt(p) features)
random_forest_bankrupt = RandomForestClassifier(max_features='sqrt', random_state=1)

# Fit the model on the training data
random_forest_bankrupt.fit(x_train, np.ravel(y_train))

# Make predictions for train and test sets
y_train_pred_rf = random_forest_bankrupt.predict(x_train)
y_test_pred_rf = random_forest_bankrupt.predict(x_test)

print("-------------------------------------2.2-2-------------------------------------")

# Evaluate the model on training data
print("Training Set Confusion Matrix (Random Forest):")
print(confusion_matrix(y_train, y_train_pred_rf))
print("\nTraining Set Classification Report (Random Forest):")
print(classification_report(y_train, y_train_pred_rf))

# Evaluate the model on test data
print("\nTest Set Confusion Matrix (Random Forest):")
print(confusion_matrix(y_test, y_test_pred_rf))
print("\nTest Set Classification Report (Random Forest):")
print(classification_report(y_test, y_test_pred_rf))

# -------------------------------------2.2-2-------------------------------------#
# Initialize AdaBoostClassifier with maximum number of estimators set to 4
adaboost_bankrupt = AdaBoostClassifier(n_estimators=4, random_state=1)

# Fit the AdaBoost model on the training data
adaboost_bankrupt.fit(x_train, np.ravel(y_train))

# Make predictions for train and test sets
y_train_pred_adaboost = adaboost_bankrupt.predict(x_train)
y_test_pred_adaboost = adaboost_bankrupt.predict(x_test)

print("-------------------------------------2.2-3-------------------------------------")

# Evaluate the model on training data
print("Training Set Confusion Matrix (AdaBoost):")
print(confusion_matrix(y_train, y_train_pred_adaboost))
print("\nTraining Set Classification Report (AdaBoost):")
print(classification_report(y_train, y_train_pred_adaboost))

# Evaluate the model on test data
print("\nTest Set Confusion Matrix (AdaBoost):")
print(confusion_matrix(y_test, y_test_pred_adaboost))
print("\nTest Set Classification Report (AdaBoost):")
print(classification_report(y_test, y_test_pred_adaboost))

# -------------------------------------2.2-4-------------------------------------#
print("\n-------------------------------------2.2-4-------------------------------------")
print("Bagging Feature Importances:")
print(bagging_bankrupt.feature_importances_)

# Plotting bagging feature importance
Importance_bagging = pd.DataFrame({'Importance': bagging_bankrupt.feature_importances_ * 100}, index=x_train.columns)
Importance_bagging.sort_values(by='Importance', axis=0, ascending=True).plot(kind='barh')
plt.xlabel('Variable Importance (Bagging)')
plt.title('Bagging Classifier Variable Importance')
plt.show()

# Feature Importance - Random Forest
print("Random Forest Feature Importances:")
print(random_forest_bankrupt.feature_importances_)

# Plotting random forest feature importance
Importance_rf = pd.DataFrame({'Importance': random_forest_bankrupt.feature_importances_ * 100}, index=x_train.columns)
Importance_rf.sort_values(by='Importance', axis=0, ascending=True).plot(kind='barh')
plt.xlabel('Variable Importance (Random Forest)')
plt.title('Random Forest Classifier Variable Importance')
plt.show()

# Feature Importance - AdaBoost
print("AdaBoost Feature Importances:")
print(adaboost_bankrupt.feature_importances_)

# Plotting adaboost feature importance
Importance_adaboost = pd.DataFrame({'Importance': adaboost_bankrupt.feature_importances_ * 100}, index=x_train.columns)
Importance_adaboost.sort_values(by='Importance', axis=0, ascending=True).plot(kind='barh')
plt.xlabel('Variable Importance (AdaBoost)')
plt.title('AdaBoost Classifier Variable Importance')
plt.show()