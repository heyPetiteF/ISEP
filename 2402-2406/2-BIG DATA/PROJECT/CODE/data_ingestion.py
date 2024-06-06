import requests
import pandas as pd
from datetime import datetime, timedelta

# Embed the API key and URL directly in the script
AQI_API_TOKEN = ''
FLUVIEW_API_URL = 'https://api.delphi.cmu.edu/epidata/fluview/'

# Function to fetch air quality data
def fetch_air_quality_data(city):
    url = f'https://api.waqi.info/feed/{city}/?token={AQI_API_TOKEN}'
    response = requests.get(url)
    data = response.json()
    print("Air Quality API Response:", data)  # Print debug information
    if data['status'] == 'ok' and 'data' in data:
        return data['data']
    else:
        raise ValueError(f"Failed to retrieve air quality data: {data}")

# Function to fetch flu surveillance data
def fetch_flu_data(regions, epiweeks):
    params = {
        'regions': ','.join(regions),
        'epiweeks': ','.join(epiweeks)
    }
    response = requests.get(FLUVIEW_API_URL, params=params)
    if response.status_code == 200:
        data = response.json()
        if data['result'] == 1:
            return data['epidata']
        else:
            raise ValueError(f"Failed to retrieve flu data: {data['message']}")
    else:
        raise ValueError(f"Failed to retrieve flu data: {response.status_code}")

try:
    # Fetch air quality data for Chicago
    air_quality_data = fetch_air_quality_data('chicago')

    # Check data structure and convert to DataFrame
    if 'iaqi' in air_quality_data:
        iaqi_data = air_quality_data['iaqi']
        air_quality_df = pd.json_normalize(iaqi_data)
        air_quality_df['date'] = air_quality_data['time']['s']
    else:
        raise ValueError("Invalid air quality data structure")

    # Fetch flu surveillance data
    regions = ['il']  # Example for Illinois
    epiweeks = ['202201', '202202', '202203']  # Example list of epiweeks, adjust as needed
    flu_data = fetch_flu_data(regions, epiweeks)
    if flu_data:
        flu_df = pd.DataFrame(flu_data)

        # Save data to CSV
        air_quality_df.to_csv('air_quality_data.csv', index=False)
        flu_df.to_csv('flu_data.csv', index=False)
        print("Data ingestion complete. Air quality and flu data saved as CSV.")
    else:
        print("Failed to fetch flu data.")

except Exception as e:
    print(f"Error: {e}")

# Generate sample air quality data
air_quality_data = {
    'h.v': [54, 55, 56],
    'p.v': [1004.2, 1005.0, 1003.8],
    'pm25.v': [13, 15, 12],
    't.v': [26.1, 26.5, 25.8],
    'w.v': [6, 5, 7],
    'wg.v': [10, 12, 9],
    'date': [(datetime.now() - timedelta(days=i)).strftime('%Y-%m-%d') for i in range(3)]
}

air_quality_df = pd.DataFrame(air_quality_data)
air_quality_df.to_csv('air_quality_data.csv', index=False)

# Generate sample flu data
flu_data = {
    'release_date': [(datetime.now() - timedelta(days=i)).strftime('%Y-%m-%d') for i in range(3)],
    'region': ['il', 'il', 'il'],
    'issue': [202339, 202338, 202337],
    'epiweek': [202201, 202202, 202203],
    'lag': [90, 89, 88],
    'num_ili': [2692, 1772, 1287],
    'num_patients': [77490, 75128, 67778],
    'num_providers': [1500, 1490, 1485],
    'num_age_0': [100, 110, 105],
    'num_age_1': [200, 210, 205],
    'num_age_2': [300, 310, 305],
    'num_age_3': [400, 410, 405],
    'num_age_4': [500, 510, 505],
    'num_age_5': [600, 610, 605],
    'wili': [3.5, 2.4, 1.9],
    'ili': [3.5, 2.4, 1.9]
}

flu_df = pd.DataFrame(flu_data)
flu_df.to_csv('flu_data.csv', index=False)
