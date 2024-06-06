import pandas as pd
from datetime import datetime

# 读取空气质量数据
air_quality_df = pd.read_csv('air_quality_data.csv')

# 格式化空气质量数据
air_quality_df['date'] = pd.to_datetime(air_quality_df['date'])

# 重命名列名
air_quality_df = air_quality_df.rename(columns={
    'h.v': 'humidity',
    'p.v': 'pressure',
    'pm25.v': 'pm25',
    't.v': 'temperature',
    'w.v': 'wind_speed',
    'wg.v': 'wind_gust'
})

# 处理缺失值（例如：填充缺失值或删除含有缺失值的行）
air_quality_df = air_quality_df.dropna()  # 这里选择删除缺失值的行，或者可以使用 air_quality_df.fillna(method='ffill') 填充缺失值

# 确保数据类型正确
air_quality_df['humidity'] = air_quality_df['humidity'].astype(float)
air_quality_df['pressure'] = air_quality_df['pressure'].astype(float)
air_quality_df['pm25'] = air_quality_df['pm25'].astype(float)
air_quality_df['temperature'] = air_quality_df['temperature'].astype(float)
air_quality_df['wind_speed'] = air_quality_df['wind_speed'].astype(float)
air_quality_df['wind_gust'] = air_quality_df['wind_gust'].astype(float)

# 保存格式化后的空气质量数据
air_quality_df.to_csv('formatted_air_quality_data.csv', index=False)

# 读取流感数据
flu_df = pd.read_csv('flu_data.csv')

# 格式化流感数据
flu_df['release_date'] = pd.to_datetime(flu_df['release_date'])

# 处理缺失值
flu_df = flu_df.dropna()  # 同样地，这里选择删除缺失值的行，或者使用填充方法

# 确保数据类型正确
flu_df['issue'] = flu_df['issue'].astype(int)
flu_df['epiweek'] = flu_df['epiweek'].astype(int)
flu_df['lag'] = flu_df['lag'].astype(int)
flu_df['num_ili'] = flu_df['num_ili'].astype(int)
flu_df['num_patients'] = flu_df['num_patients'].astype(int)
flu_df['num_providers'] = flu_df['num_providers'].astype(int)
flu_df['num_age_0'] = flu_df['num_age_0'].astype(float)
flu_df['num_age_1'] = flu_df['num_age_1'].astype(float)
flu_df['num_age_2'] = flu_df['num_age_2'].astype(float)
flu_df['num_age_3'] = flu_df['num_age_3'].astype(float)
flu_df['num_age_4'] = flu_df['num_age_4'].astype(float)
flu_df['num_age_5'] = flu_df['num_age_5'].astype(float)
flu_df['wili'] = flu_df['wili'].astype(float)
flu_df['ili'] = flu_df['ili'].astype(float)

# 保存格式化后的流感数据
flu_df.to_csv('formatted_flu_data.csv', index=False)

print("Data formatting complete. Formatted data saved as CSV.")
