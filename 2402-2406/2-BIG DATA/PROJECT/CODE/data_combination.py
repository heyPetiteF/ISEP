from pyspark.sql import SparkSession
from pyspark.sql.functions import col

# Initialize Spark session
spark = SparkSession.builder \
    .appName("DataCombination") \
    .getOrCreate()

# Read formatted air quality data
formatted_air_quality_df = spark.read.csv('formatted_air_quality_data.csv', header=True, inferSchema=True)

# Read formatted flu data
formatted_flu_df = spark.read.csv('formatted_flu_data.csv', header=True, inferSchema=True)

# Join data on date columns, considering the different possible date columns in flu data
combined_df = formatted_flu_df.join(formatted_air_quality_df, formatted_flu_df.start_date == formatted_air_quality_df.date, how='inner') \
                              .drop(formatted_air_quality_df.date)

# Save combined data
combined_df.write.csv('combined_data.csv', header=True, mode='overwrite')

print("Data combination complete. Combined data saved as CSV.")

# Stop the Spark session
spark.stop()
