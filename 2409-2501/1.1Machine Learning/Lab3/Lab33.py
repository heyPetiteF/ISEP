import pandas as pd
from sklearn.svm import SVC
from sklearn.metrics import confusion_matrix, classification_report, roc_curve, auc
import matplotlib.pyplot as plt
import numpy as np

# 加载数据集
x_train = pd.read_csv('C:\\Users\\16273\\GitHub\\ISEP-Documents\\2409-2501\\1.1Machine Learning\\Lab3\\x_train.csv')
x_test = pd.read_csv('C:\\Users\\16273\\GitHub\\ISEP-Documents\\2409-2501\\1.1Machine Learning\\Lab3\\x_test.csv')
y_train = pd.read_csv('C:\\Users\\16273\\GitHub\\ISEP-Documents\\2409-2501\\1.1Machine Learning\\Lab3\\y_train.csv', usecols=['Bankrupt']).squeeze()
y_test = pd.read_csv('C:\\Users\\16273\\GitHub\\ISEP-Documents\\2409-2501\\1.1Machine Learning\\Lab3\\y_test.csv', usecols=['Bankrupt']).squeeze()

# 使用最佳参数训练线性 SVM 模型 (从第1问或直接设定为 1, 比如C=1)
svc = SVC(kernel='linear', C=1)
svc.fit(x_train, y_train)

# 在训练集和测试集上进行预测
y_pred_train = svc.predict(x_train)
y_pred_test = svc.predict(x_test)

# 生成混淆矩阵和分类报告
print("Confusion matrix for train data:")
print(confusion_matrix(y_train, y_pred_train))

print("Classification report for train data:")
print(classification_report(y_train, y_pred_train))

print("Confusion matrix for test data:")
print(confusion_matrix(y_test, y_pred_test))

print("Classification report for test data:")
print(classification_report(y_test, y_pred_test))

# 绘制 ROC 曲线
y_scores = svc.decision_function(x_test)
fpr, tpr, _ = roc_curve(y_test, y_scores)
roc_auc = auc(fpr, tpr)

plt.figure()
plt.plot(fpr, tpr, color='darkorange', lw=2, label='ROC curve (area = %0.2f)' % roc_auc)
plt.plot([0, 1], [0, 1], color='navy', lw=2, linestyle='--')
plt.xlim([0.0, 1.0])
plt.ylim([0.0, 1.05])
plt.xlabel('False Positive Rate')
plt.ylabel('True Positive Rate')
plt.title('ROC Curve for Linear SVM')
plt.legend(loc="lower right")
plt.show()
