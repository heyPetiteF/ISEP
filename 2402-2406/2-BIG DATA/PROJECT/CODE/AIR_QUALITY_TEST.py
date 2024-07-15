import requests
import pandas as pd

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
            'date': data['data']['time']['s'],
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

try:
    # Fetch air quality data
    current_data, forecast_data = fetch_air_quality_data('chicago')
    
    current_df = pd.DataFrame(current_data)
    forecast_df = pd.DataFrame(forecast_data)
    
    # print("Current air quality data columns:\n", current_df.columns)  # Print column names for debugging
    # print("Current air quality data sample:\n", current_df.head())  # Print data sample for debugging
    # print("Forecast air quality data columns:\n", forecast_df.columns)  # Print column names for debugging
    # print("Forecast air quality data sample:\n", forecast_df.head())  # Print data sample for debugging

    if current_df.empty:
        raise ValueError("Current air quality data is empty after fetching.")
    if forecast_df.empty:
        raise ValueError("Forecast air quality data is empty after fetching.")

    # Pivot the forecast data to have one row per date with all pollutants as columns
    forecast_pivot_df = forecast_df.pivot(index='date', columns='type', values=['avg', 'max', 'min']).reset_index()
    forecast_pivot_df.columns = ['_'.join(col).strip() if col[1] else col[0] for col in forecast_pivot_df.columns.values]

    # print("Pivoted forecast air quality data columns:\n", forecast_pivot_df.columns)  # Print column names for debugging
    print("Pivoted forecast air quality data sample:\n", forecast_pivot_df.head())  # Print data sample for debugging

    current_df.to_csv('current_air_quality_data.csv', index=False)
    forecast_pivot_df.to_csv('forecast_air_quality_data.csv', index=False)
    print("Data ingestion complete. Air quality data saved as CSV.")

except Exception as e:
    print(f"Error: {e}")
