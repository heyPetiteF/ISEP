import pandas as pd
import matplotlib.pyplot as plt

# Read CSV files
air_quality_df = pd.read_csv('air_quality_data.csv')
flu_df = pd.read_csv('flu_data.csv')

# Data inspection
print("Air Quality Data:")
print(air_quality_df.head())

print("Flu Data:")
print(flu_df.head())

# Data information
print("\nAir Quality Data Info:")
print(air_quality_df.info())
print("\nFlu Data Info:")
print(flu_df.info())

# Descriptive statistics
print("\nAir Quality Data Description:")
print(air_quality_df.describe())
print("\nFlu Data Description:")
print(flu_df.describe())

# Data preprocessing
air_quality_df['date'] = pd.to_datetime(air_quality_df['date'])
flu_df['release_date'] = pd.to_datetime(flu_df['release_date'])

# Visualize PM2.5 data
air_quality_df.plot(x='date', y='pm25.v', kind='line', title='PM2.5 Levels Over Time')
plt.xlabel('Date')
plt.ylabel('PM2.5 Level')
plt.show()

# Visualize flu data
flu_df.plot(x='epiweek', y='num_ili', kind='line', title='Influenza-like Illness Cases Over Time')
plt.xlabel('Epiweek')
plt.ylabel('Number of ILI Cases')
plt.show()
