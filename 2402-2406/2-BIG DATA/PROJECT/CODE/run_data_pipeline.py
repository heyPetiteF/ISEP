import subprocess

# 运行数据提取脚本
subprocess.run(["python", "data_ingestion.py"])

# 运行数据格式化脚本
subprocess.run(["python", "data_formatting.py"])

# 运行数据组合脚本
subprocess.run(["python", "data_combination.py"])

# 运行数据索引脚本
subprocess.run(["python", "data_indexing.py"])

print("Data pipeline complete.")
