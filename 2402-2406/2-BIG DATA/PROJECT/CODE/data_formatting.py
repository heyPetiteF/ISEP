from pyspark.sql import SparkSession
from pyspark.sql.functions import col, to_date

# Initialize Spark session
spark = SparkSession.builder \
    .appName("DataFormatting") \
    .getOrCreate()

# Read air quality data
air_quality_df = spark.read.csv('air_quality_data.csv', header=True, inferSchema=True)

# Format air quality data
air_quality_df = air_quality_df.withColumn('date', to_date(col('date'), 'yyyy-MM-dd'))

# Rename columns if they exist
rename_columns = {
    'h.v': 'humidity',
    'p.v': 'pressure',
    'pm25.v': 'pm25',
    't.v': 'temperature',
    'w.v': 'wind_speed',
    'wg.v': 'wind_gust'
}

for old_col, new_col in rename_columns.items():
    if old_col in air_quality_df.columns:
        air_quality_df = air_quality_df.withColumnRenamed(old_col, new_col)

# Handle missing values (e.g., fill missing values or drop rows with missing values)
air_quality_df = air_quality_df.dropna()  # Here we choose to drop rows with missing values, or you can use .fillna(method='ffill') to fill missing values

# Ensure correct data types
expected_columns = ['humidity', 'pressure', 'pm25', 'temperature', 'wind_speed', 'wind_gust']
for column in expected_columns:
    if column in air_quality_df.columns:
        air_quality_df = air_quality_df.withColumn(column, col(column).cast('float'))

# Save formatted air quality data
air_quality_df.write.csv('formatted_air_quality_data.csv', header=True, mode='overwrite')

# Read flu data
flu_df = spark.read.csv('flu_data.csv', header=True, inferSchema=True)

# Format flu data
flu_df = flu_df.withColumn('release_date', to_date(col('release_date'), 'yyyy-MM-dd')) \
               .withColumn('start_date', to_date(col('start_date'), 'yyyy-MM-dd')) \
               .withColumn('end_date', to_date(col('end_date'), 'yyyy-MM-dd'))

# Handle missing values
flu_df = flu_df.dropna()  # Similarly, here we choose to drop rows with missing values, or use a filling method

# Ensure correct data types
int_columns = ['issue', 'epiweek', 'lag', 'num_ili', 'num_patients', 'num_providers']
float_columns = ['num_age_0', 'num_age_1', 'num_age_2', 'num_age_3', 'num_age_4', 'num_age_5', 'wili', 'ili']

for column in int_columns:
    if column in flu_df.columns:
        flu_df = flu_df.withColumn(column, col(column).cast('int'))

for column in float_columns:
    if column in flu_df.columns:
        flu_df = flu_df.withColumn(column, col(column).cast('float'))

# Save formatted flu data
flu_df.write.csv('formatted_flu_data.csv', header=True, mode='overwrite')

print("Data formatting complete. Formatted data saved as CSV.")

# Stop the Spark session
spark.stop()
