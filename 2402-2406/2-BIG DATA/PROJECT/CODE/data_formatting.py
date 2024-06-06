import pandas as pd
from datetime import datetime

# Read air quality data
air_quality_df = pd.read_csv('air_quality_data.csv')

# Format air quality data
air_quality_df['date'] = pd.to_datetime(air_quality_df['date'])

# Rename columns
air_quality_df = air_quality_df.rename(columns={
    'h.v': 'humidity',
    'p.v': 'pressure',
    'pm25.v': 'pm25',
    't.v': 'temperature',
    'w.v': 'wind_speed',
    'wg.v': 'wind_gust'
})

# Handle missing values (e.g., fill missing values or drop rows with missing values)
air_quality_df = air_quality_df.dropna()  # Here we choose to drop rows with missing values, or you can use air_quality_df.fillna(method='ffill') to fill missing values

# Ensure correct data types
air_quality_df['humidity'] = air_quality_df['humidity'].astype(float)
air_quality_df['pressure'] = air_quality_df['pressure'].astype(float)
air_quality_df['pm25'] = air_quality_df['pm25'].astype(float)
air_quality_df['temperature'] = air_quality_df['temperature'].astype(float)
air_quality_df['wind_speed'] = air_quality_df['wind_speed'].astype(float)
air_quality_df['wind_gust'] = air_quality_df['wind_gust'].astype(float)

# Save formatted air quality data
air_quality_df.to_csv('formatted_air_quality_data.csv', index=False)

# Read flu data
flu_df = pd.read_csv('flu_data.csv')

# Format flu data
flu_df['release_date'] = pd.to_datetime(flu_df['release_date'])

# Handle missing values
flu_df = flu_df.dropna()  # Similarly, here we choose to drop rows with missing values, or use a filling method

# Ensure correct data types
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

# Save formatted flu data
flu_df.to_csv('formatted_flu_data.csv', index=False)

print("Data formatting complete. Formatted data saved as CSV.")
