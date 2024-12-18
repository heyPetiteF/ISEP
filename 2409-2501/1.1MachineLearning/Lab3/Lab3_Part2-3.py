import pandas as pd
from sklearn.svm import SVC
from sklearn.model_selection import GridSearchCV
from sklearn.metrics import confusion_matrix, classification_report, roc_curve, auc
import matplotlib.pyplot as plt
import numpy as np
import time

# 加载数据集，取100个样本用于训练，30个样本用于测试
print("Loading datasets...")
x_train = pd.read_csv('C:\\Users\\16273\\GitHub\\ISEP-Documents\\2409-2501\\1.1Machine Learning\\Lab3\\x_train.csv').head(100)
x_test = pd.read_csv('C:\\Users\\16273\\GitHub\\ISEP-Documents\\2409-2501\\1.1Machine Learning\\Lab3\\x_test.csv').head(30)
y_train = pd.read_csv('C:\\Users\\16273\\GitHub\\ISEP-Documents\\2409-2501\\1.1Machine Learning\\Lab3\\y_train.csv', usecols=['Bankrupt']).squeeze().head(100)
y_test = pd.read_csv('C:\\Users\\16273\\GitHub\\ISEP-Documents\\2409-2501\\1.1Machine Learning\\Lab3\\y_test.csv', usecols=['Bankrupt']).squeeze().head(30)

print("Datasets loaded successfully.")

# -------------------------------------2.3-1-------------------------------------#
# 训练线性核的SVM并找到最佳参数（简化参数空间以加快速度）
print("Starting linear SVM with GridSearchCV...")

# 减少参数搜索范围并将交叉验证设置为2折（cv至少为2）
tuned_parameters = [{'C': [0.1, 1]}]
svc = SVC(kernel='linear')

grid_search = GridSearchCV(svc, tuned_parameters, cv=2, scoring='balanced_accuracy', n_jobs=-1)
grid_search.fit(x_train, y_train)

# 输出最佳参数
best_C = grid_search.best_params_
print("最佳参数：", best_C)

# -------------------------------------2.3-2-------------------------------------#
# 生成混淆矩阵和分类报告
print("Generating performance metrics for linear SVM...")
y_pred_train = grid_search.predict(x_train)
y_pred_test = grid_search.predict(x_test)

# 显示训练集的混淆矩阵和分类报告
print("Confusion matrix for train data:")
print(confusion_matrix(y_train, y_pred_train))

print("Classification report for train data:")
print(classification_report(y_train, y_pred_train))

# 显示测试集的混淆矩阵和分类报告
print("Confusion matrix for test data:")
print(confusion_matrix(y_test, y_pred_test))

print("Classification report for test data:")
print(classification_report(y_test, y_pred_test))

# -------------------------------------2.3-3-------------------------------------#
# 使用RBF核的SVM进行训练和评估
print("Training radial SVM...")

# 减少C和gamma的搜索范围，并将交叉验证次数减少
tuned_parameters_rbf = [{'C': [1], 'gamma': [0.1]}]
svc_rbf = SVC(kernel='rbf')

grid_search_rbf = GridSearchCV(svc_rbf, tuned_parameters_rbf, cv=2, scoring='balanced_accuracy', n_jobs=-1)
grid_search_rbf.fit(x_train, y_train)

# 输出最佳参数
best_params_rbf = grid_search_rbf.best_params_
print("Best values for C and gamma for radial SVM:", best_params_rbf)

# 在训练集和测试集上进行预测
y_pred_train_rbf = grid_search_rbf.predict(x_train)
y_pred_test_rbf = grid_search_rbf.predict(x_test)

# 生成混淆矩阵和分类报告
print("Confusion matrix for train data with radial SVM:")
print(confusion_matrix(y_train, y_pred_train_rbf))

print("Classification report for train data with radial SVM:")
print(classification_report(y_train, y_pred_train_rbf))

print("Confusion matrix for test data with radial SVM:")
print(confusion_matrix(y_test, y_pred_test_rbf))

print("Classification report for test data with radial SVM:")
print(classification_report(y_test, y_pred_test_rbf))
