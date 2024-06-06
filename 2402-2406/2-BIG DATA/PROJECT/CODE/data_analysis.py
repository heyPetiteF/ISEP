import pandas as pd
import matplotlib.pyplot as plt

# 读取CSV文件
air_quality_df = pd.read_csv('air_quality_data.csv')
print("Air Quality Data:")
print(air_quality_df.head())

flu_df = pd.read_csv('flu_data.csv')
print("Flu Data:")
print(flu_df.head())

# 数据检查
print("\nAir Quality Data Info:")
print(air_quality_df.info())
print("\nFlu Data Info:")
print(flu_df.info())

# 描述性统计
print("\nAir Quality Data Description:")
print(air_quality_df.describe())
print("\nFlu Data Description:")
print(flu_df.describe())

# 简单可视化
# 如果空气质量数据只有一条记录，可以添加一些示例数据点来展示如何绘制折线图
if len(air_quality_df) == 1:
    example_data = {
        'date': ['2024-06-05 13:00:00', '2024-06-06 13:00:00', '2024-06-07 13:00:00'],
        'pm25.v': [13, 20, 15]
    }
    air_quality_df = pd.DataFrame(example_data)

air_quality_df['date'] = pd.to_datetime(air_quality_df['date'])
air_quality_df.plot(x='date', y='pm25.v', kind='line', title='PM2.5 Levels Over Time')
plt.xlabel('Date')
plt.ylabel('PM2.5 Level')
plt.show()

flu_df.plot(x='epiweek', y='num_ili', kind='line', title='Influenza-like Illness Cases Over Time')
plt.xlabel('Epiweek')
plt.ylabel('Number of ILI Cases')
plt.show()
