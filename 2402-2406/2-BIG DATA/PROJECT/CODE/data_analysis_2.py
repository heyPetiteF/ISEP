import pandas as pd
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_squared_error

# Read CSV files
air_quality_df = pd.read_csv('air_quality_data.csv')
flu_df = pd.read_csv('flu_data.csv')

# Data cleaning and preprocessing
air_quality_df['date'] = pd.to_datetime(air_quality_df['date'])
flu_df['release_date'] = pd.to_datetime(flu_df['release_date'])

# Print datasets to check contents
print("\nAir Quality Data:")
print(air_quality_df)
print("\nFlu Data:")
print(flu_df)

# Print date ranges
print("\nAir Quality Data Date Range:")
print(air_quality_df['date'].min(), air_quality_df['date'].max())
print("\nFlu Data Date Range:")
print(flu_df['release_date'].min(), flu_df['release_date'].max())

# Try different merging methods
merged_df = pd.merge(flu_df, air_quality_df, left_on='release_date', right_on='date', how='inner')

# Print merged dataset to check contents
print("\nMerged Data:")
print(merged_df)

# Select relevant columns for analysis
analysis_df = merged_df[['release_date', 'num_ili', 'pm25.v']].dropna()

# Data inspection
print("\nMerged Data Info:")
print(analysis_df.info())

# Correlation analysis
correlation = analysis_df['num_ili'].corr(analysis_df['pm25.v'])
print(f"\nCorrelation between PM2.5 and ILI: {correlation}")

# Data visualization
plt.scatter(analysis_df['pm25.v'], analysis_df['num_ili'])
plt.xlabel('PM2.5 Level')
plt.ylabel('Number of ILI Cases')
plt.title('PM2.5 vs ILI Cases')
plt.show()

# Build a prediction model
X = analysis_df[['pm25.v']]
y = analysis_df['num_ili']

if len(X) > 0:
    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

    model = LinearRegression()
    model.fit(X_train, y_train)

    y_pred = model.predict(X_test)

    # Calculate mean squared error
    mse = mean_squared_error(y_test, y_pred)
    print(f"\nMean Squared Error: {mse}")

    # Visualize prediction results
    plt.scatter(X_test, y_test, color='black', label='Actual')
    plt.scatter(X_test, y_pred, color='blue', label='Predicted')
    plt.xlabel('PM2.5 Level')
    plt.ylabel('Number of ILI Cases')
    plt.title('Actual vs Predicted ILI Cases')
    plt.legend()
    plt.show()
else:
    print("Not enough data to train the model.")
