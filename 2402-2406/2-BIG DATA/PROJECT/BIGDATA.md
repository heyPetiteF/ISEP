# 创建数据管道
## 数据获取（Ingestion）

1. 安装python库
```
pip install requests beautifulsoup4 pandas
```
2. 创建data_ingestion.py
3. /*忽略这一步，调用一直显示api错误。直接嵌入*/
    为确保API密钥的安全性：
    1）安装dotenv库
    ```
    pip install python-dotenv
    ```
### 读取和检查CSV
1. 安装库
```
pip install pandas matplotlib
```
2. 创建data_analysis.py并运行。
3. PowerShell 中运行以下命令来安装 scikit-learn, 进行线性回归分析。

## 数据格式化（Formatting）
1. 安装pandas库
```
pip install pandas
```
2. 创建data_formatting.py

##  数据组合（Combination）
1. 创建data_combination.py

## 管道搭建(pipeline)
```
pip install elasticsearch
```
2. 创建文件
## 数据索引（Indexing）
1. 安装Elasticsearch和Kibana
```
docker pull elasticsearch:7.9.3
docker pull kibana:7.9.3
docker run -d -p 9200:9200 -e "discovery.type=single-node" --name elasticsearch elasticsearch:7.9.3
docker run -d -p 5601:5601 --link elasticsearch:elasticsearch --name kibana kibana:7.9.3
```
2. 安装elasticsearch库
```
pip install elasticsearch
```
3. 创建data_indexing.py

# Docker-> Elasticsearch 
1. 启动 Elasticsearch Docker 容器
```
docker run -p 9200:9200 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:8.13.2
```

2. 验证 Elasticsearch 服务
```
http://localhost:9200
```




# 代码功能总结

## `data_ingestion.py`
**目的**: 数据提取和初步存储
- 从互联网获取空气质量数据和流感数据。
- 将获取的数据转换为 `pandas` DataFrame 格式。
- 将数据保存为 CSV 文件。

## `data_analysis.py`
**目的**: 数据初步分析和可视化
- 读取存储在 CSV 文件中的空气质量数据和流感数据。
- 对数据进行基本的描述性统计分析。
- 生成简单的折线图，用于展示 PM2.5 水平和流感病例的变化趋势。

## `data_analysis_2.py`
**目的**: 数据合并、详细分析和模型构建
- 读取 CSV 文件中的数据。
- 清洗和预处理数据。
- 合并空气质量数据和流感数据。
- 进行相关性分析。
- 构建和评估线性回归模型，预测流感病例数。
- 可视化实际值和预测值。

## `data_formatting.py`
**目的**: 数据格式化和标准化
- 对获取的原始数据进行清洗和标准化处理。
- 确保数据符合 Datalake 的存储格式和要求。

## `data_combination.py`
**目的**: 数据组合
- 将格式化后的空气质量数据和流感数据进行合并。
- 处理数据的时间对齐问题，确保数据可以在同一时间段内进行分析。

## `data_indexing.py`
**目的**: 数据索引
- 读取合并后的数据文件。
- 将数据索引到 Elasticsearch 中，以便在 Kibana 中进行可视化展示。

## `data_pipeline.py`
**目的**: 数据处理管道
- 统一执行整个数据处理流程，从数据提取到数据索引。
- 调用各个独立脚本 (`data_ingestion.py`, `data_formatting.py`, `data_combination.py`, `data_indexing.py`) 以完成数据处理的所有步骤。

## 总结
1. **数据提取 (data_ingestion.py)**: 负责从 API 获取原始数据并存储为 CSV 文件。
2. **数据格式化 (data_formatting.py)**: 负责清洗和标准化原始数据。
3. **数据组合 (data_combination.py)**: 负责将空气质量数据和流感数据合并为一个数据集。
4. **数据索引 (data_indexing.py)**: 负责将合并后的数据索引到 Elasticsearch 中。
5. **数据管道 (data_pipeline.py)**: 负责串联以上所有步骤，确保数据从提取到索引的整个流程顺利进行。
6. **数据分析 (data_analysis.py 和 data_analysis_2.py)**: 负责对数据进行描述性统计分析、可视化和建模分析。
