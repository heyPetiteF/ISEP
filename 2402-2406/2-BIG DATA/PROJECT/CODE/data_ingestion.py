import requests
import pandas as pd
from datetime import datetime, timedelta
import time

# Embed the API key and URL directly in the script
AQI_API_TOKEN = 'ef523b682a02576fd62939114fb78b63dfe9e5ad'
FLUVIEW_API_URL = 'https://api.delphi.cmu.edu/epidata/fluview/'

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

# Function to convert epiweek to start and end dates
def epiweek_to_dates(year, epiweek):
    first_day_of_year = datetime(year, 1, 1)
    first_sunday = first_day_of_year + timedelta(days=(6 - first_day_of_year.weekday()))
    start_date = first_sunday + timedelta(weeks=(epiweek - 1))
    end_date = start_date + timedelta(days=6)
    return start_date, end_date

# Function to fetch flu surveillance data for multiple epiweeks
def fetch_flu_data_for_weeks(regions, epiweeks):
    all_flu_data = []
    for epiweek in epiweeks:
        params = {
            'regions': ','.join(regions),
            'epiweeks': epiweek
        }
        response = requests.get(FLUVIEW_API_URL, params=params)
        if response.status_code == 200:
            data = response.json()
            if data['result'] == 1:
                for item in data['epidata']:
                    year = int(epiweek[:4])
                    week = int(epiweek[4:])
                    item['start_date'], item['end_date'] = epiweek_to_dates(year, week)
                    all_flu_data.append(item)
            else:
                print(f"Failed to retrieve flu data for epiweek {epiweek}: {data['message']}")
        else:
            print(f"Failed to retrieve flu data for epiweek {epiweek}: {response.status_code}")
        time.sleep(1)  # Add a delay of 1 second between each request
    return all_flu_data

try:
    # Fetch flu surveillance data for the last 5 weeks
    regions = ['il']  # Example for Illinois
    end_date = datetime.now()
    start_date = end_date - timedelta(weeks=9)  # Extend to 9 weeks back to ensure at least 5 valid epiweeks
    epiweeks = []
    current_date = start_date
    while current_date <= end_date:
        year = current_date.year
        week = current_date.isocalendar()[1]
        epiweeks.append(f"{year}{week:02d}")
        current_date += timedelta(weeks=1)
    
    flu_data = fetch_flu_data_for_weeks(regions, epiweeks)
    if flu_data:
        flu_df = pd.DataFrame(flu_data)
        # print("Flu data columns:\n", flu_df.columns)  # Print column names for debugging
        print("Flu data sample:\n", flu_df.head())  # Print data sample for debugging

        if flu_df.empty:
            raise ValueError("Flu data is empty after fetching.")

        flu_df.to_csv('flu_data.csv', index=False)

        # Fetch air quality data
        current_data, forecast_data = fetch_air_quality_data('chicago')
        
        current_df = pd.DataFrame(current_data)
        forecast_df = pd.DataFrame(forecast_data)
        
        # print("Current air quality data columns:", current_df.columns)  # Print column names for debugging
        # print("Current air quality data sample:", current_df.head())  # Print data sample for debugging
        # print("Forecast air quality data columns:", forecast_df.columns)  # Print column names for debugging
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

    else:
        print("Failed to fetch flu data.")

except Exception as e:
    print(f"Error: {e}")
