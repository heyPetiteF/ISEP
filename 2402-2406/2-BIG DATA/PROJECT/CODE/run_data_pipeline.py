import subprocess

# Run data ingestion script
subprocess.run(["python", "data_ingestion.py"])

# Run data formatting script
subprocess.run(["python", "data_formatting.py"])

# Run data combination script
subprocess.run(["python", "data_combination.py"])

# Run data indexing script
subprocess.run(["python", "data_indexing.py"])

print("Data pipeline complete.")
