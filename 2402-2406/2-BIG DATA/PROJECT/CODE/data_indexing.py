from elasticsearch import Elasticsearch, helpers
import pandas as pd

try:
    # Read the combined dataset
    combined_df = pd.read_csv('combined_data.csv')

    # Connect to Elasticsearch
    es = Elasticsearch(['http://localhost:9200'])

    # Check Elasticsearch connection
    if not es.ping():
        raise ValueError("Elasticsearch connection failed.")

    # Create index (if it doesn't exist)
    index_name = 'air_quality_flu_data'
    if not es.indices.exists(index=index_name):
        es.indices.create(index=index_name)

    # Prepare data for bulk indexing
    actions = [
        {
            "_index": index_name,
            "_source": row.to_dict()
        }
        for _, row in combined_df.iterrows()
    ]

    # Bulk index data
    helpers.bulk(es, actions)

    print("Data indexing complete. Data indexed to Elasticsearch.")

except FileNotFoundError as e:
    print(f"File not found: {e.filename}")
except pd.errors.EmptyDataError:
    print("No data: The combined data file is empty.")
except ValueError as e:
    print(f"Value error: {e}")
except Exception as e:
    print(f"An error occurred: {e}")
