import pandas as pd
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_squared_error

# 读取CSV文件
air_quality_df = pd.read_csv('air_quality_data.csv')
flu_df = pd.read_csv('flu_data.csv')

# 数据清洗和预处理
air_quality_df['date'] = pd.to_datetime(air_quality_df['date'])
flu_df['release_date'] = pd.to_datetime(flu_df['release_date'])

# 打印数据集以检查内容
print("\nAir Quality Data:")
print(air_quality_df)
print("\nFlu Data:")
print(flu_df)

# 打印日期范围
print("\nAir Quality Data Date Range:")
print(air_quality_df['date'].min(), air_quality_df['date'].max())
print("\nFlu Data Date Range:")
print(flu_df['release_date'].min(), flu_df['release_date'].max())

# 尝试不同的合并方法
merged_df = pd.merge(flu_df, air_quality_df, left_on='release_date', right_on='date', how='inner')

# 打印合并后的数据集以检查内容
print("\nMerged Data:")
print(merged_df)

# 选择相关列进行分析
analysis_df = merged_df[['release_date', 'num_ili', 'pm25.v']].dropna()

# 数据检查
print("\nMerged Data Info:")
print(analysis_df.info())

# 相关性分析
correlation = analysis_df['num_ili'].corr(analysis_df['pm25.v'])
print(f"\nCorrelation between PM2.5 and ILI: {correlation}")

# 数据可视化
plt.scatter(analysis_df['pm25.v'], analysis_df['num_ili'])
plt.xlabel('PM2.5 Level')
plt.ylabel('Number of ILI Cases')
plt.title('PM2.5 vs ILI Cases')
plt.show()

# 构建预测模型
X = analysis_df[['pm25.v']]
y = analysis_df['num_ili']

if len(X) > 0:
    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

    model = LinearRegression()
    model.fit(X_train, y_train)

    y_pred = model.predict(X_test)

    # 计算均方误差
    mse = mean_squared_error(y_test, y_pred)
    print(f"\nMean Squared Error: {mse}")

    # 可视化预测结果
    plt.scatter(X_test, y_test, color='black', label='Actual')
    plt.scatter(X_test, y_pred, color='blue', label='Predicted')
    plt.xlabel('PM2.5 Level')
    plt.ylabel('Number of ILI Cases')
    plt.title('Actual vs Predicted ILI Cases')
    plt.legend()
    plt.show()
else:
    print("Not enough data to train the model.")
