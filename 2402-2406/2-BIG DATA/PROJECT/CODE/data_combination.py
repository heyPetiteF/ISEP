import pandas as pd

try:
    # Read the formatted data
    air_quality_df = pd.read_csv('formatted_air_quality_data.csv')
    flu_df = pd.read_csv('formatted_flu_data.csv')

    # Ensure the necessary columns exist
    if 'date' not in air_quality_df.columns or 'release_date' not in flu_df.columns:
        raise ValueError("Missing 'date' or 'release_date' columns in the data.")

    # Check data types
    air_quality_df['date'] = pd.to_datetime(air_quality_df['date'], errors='coerce')
    flu_df['release_date'] = pd.to_datetime(flu_df['release_date'], errors='coerce')

    # Ensure date conversion is correct
    if air_quality_df['date'].isnull().any() or flu_df['release_date'].isnull().any():
        raise ValueError("Date conversion error in one of the datasets.")

    # Merge data
    merged_df = pd.merge(air_quality_df, flu_df, left_on='date', right_on='release_date')

    # Check if merged data is empty
    if merged_df.empty:
        raise ValueError("Merged data is empty. Check the input data for overlapping dates.")

    # Save merged data
    merged_df.to_csv('combined_data.csv', index=False)

    print("Data combination complete. Combined data saved as CSV.")

except FileNotFoundError as e:
    print(f"File not found: {e.filename}")
except pd.errors.EmptyDataError:
    print("No data: One of the input files is empty.")
except ValueError as e:
    print(f"Value error: {e}")
except Exception as e:
    print(f"An error occurred: {e}")
