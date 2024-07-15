import requests
import pandas as pd
from datetime import datetime, timedelta

# Embed the API key directly in the script
AQI_API_TOKEN = 'ef523b682a02576fd62939114fb78b63dfe9e5ad'

# Function to fetch air quality data
def fetch_air_quality_data(city):
    current_data_list = []
    forecast_data_list = []
    url = f'https://api.waqi.info/feed/{city}/?token={AQI_API_TOKEN}'
    response = requests.get(url)
    data = response.json()
    print(f"Air Quality API Response:", data)  # Print debug information

    if data['status'] == 'ok' and 'data' in data:
        iaqi = data['data'].get('iaqi', {})
        current_data = {
            'date': data['data']['time']['s'].split(' ')[0],  # Only keep the date part
            'aqi': data['data'].get('aqi'),
            'dominentpol': data['data'].get('dominentpol'),
            'pm25': iaqi.get('pm25', {}).get('v'),
            'pm10': iaqi.get('pm10', {}).get('v'),
            'o3': iaqi.get('o3', {}).get('v'),
            'h': iaqi.get('h', {}).get('v'),
            'p': iaqi.get('p', {}).get('v'),
            't': iaqi.get('t', {}).get('v'),
            'w': iaqi.get('w', {}).get('v'),
            'wg': iaqi.get('wg', {}).get('v')
        }
        current_data_list.append(current_data)

        for forecast_type in ['o3', 'pm10', 'pm25']:
            for daily_forecast in data['data']['forecast']['daily'][forecast_type]:
                forecast_data = {
                    'date': daily_forecast['day'],
                    'type': forecast_type,
                    'avg': daily_forecast['avg'],
                    'max': daily_forecast['max'],
                    'min': daily_forecast['min']
                }
                forecast_data_list.append(forecast_data)
    else:
        print(f"Failed to retrieve air quality data: {data}")
    return current_data_list, forecast_data_list

# Define the date range
start_date = '2024-05-01'
end_date = '2024-06-20'
start_date_obj = datetime.strptime(start_date, '%Y-%m-%d')
end_date_obj = datetime.strptime(end_date, '%Y-%m-%d')

all_current_data = []
all_forecast_data = []

# Loop over each date in the date range
current_date_obj = start_date_obj
while current_date_obj <= end_date_obj:
    current_data, forecast_data = fetch_air_quality_data('chicago')
    
    # Filter current data by date range
    current_data = [data for data in current_data if start_date <= data['date'] <= end_date]
    all_current_data.extend(current_data)
    
    # Filter forecast data by date range
    forecast_data = [data for data in forecast_data if start_date <= data['date'] <= end_date]
    all_forecast_data.extend(forecast_data)
    
    current_date_obj += timedelta(days=1)

# Create DataFrames and save to CSV
current_df = pd.DataFrame(all_current_data)
forecast_df = pd.DataFrame(all_forecast_data)

if not current_df.empty:
    current_df.to_csv('historical_current_air_quality_data.csv', index=False)
    print("Data ingestion complete. Historical current air quality data saved as CSV.")
else:
    print("No current data retrieved for the specified date range.")

if not forecast_df.empty:
    forecast_df = forecast_df.drop_duplicates(subset=['date', 'type'])  # Drop duplicates
    forecast_pivot_df = forecast_df.pivot(index='date', columns='type', values=['avg', 'max', 'min']).reset_index()
    forecast_pivot_df.columns = ['_'.join(col).strip() if col[1] else col[0] for col in forecast_pivot_df.columns.values]
    forecast_pivot_df.to_csv('historical_forecast_air_quality_data.csv', index=False)
    print("Data ingestion complete. Historical forecast air quality data saved as CSV.")
else:
    print("No forecast data retrieved for the specified date range.")
