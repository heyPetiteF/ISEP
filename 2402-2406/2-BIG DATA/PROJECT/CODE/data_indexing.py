from elasticsearch import Elasticsearch, helpers
import pandas as pd

try:
    # 读取合并后的数据集
    combined_df = pd.read_csv('combined_data.csv')

    # 连接到 Elasticsearch
    es = Elasticsearch(['http://localhost:9200'])

    # 检查 Elasticsearch 连接
    if not es.ping():
        raise ValueError("Elasticsearch connection failed.")

    # 创建索引（如果不存在）
    index_name = 'air_quality_flu_data'
    if not es.indices.exists(index=index_name):
        es.indices.create(index=index_name)

    # 准备数据以进行批量索引
    actions = [
        {
            "_index": index_name,
            "_source": row.to_dict()
        }
        for _, row in combined_df.iterrows()
    ]

    # 批量索引数据
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
