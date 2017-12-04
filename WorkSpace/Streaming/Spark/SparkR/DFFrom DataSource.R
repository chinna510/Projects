library(SparkR)


#sc <- sparkR.init(master = "local[*]", appName = "From DataSource",sparkPackages="com.databricks:spark-csv_2.11:1.0.3")

sqlContext <- sparkRSQL.init(sc)

people <- read.df(sqlContext, "/home/bizruntime/Chinna/BizRuntime/DataSamples/people.json", "json")

writeToFile <- write.df(people, path = "/home/bizruntime/Chinna/BizRuntime/DataSamples/people.parquet", source="parquet", mode="overwrite")


print(head(people))

printSchema(people)

sparkR.stop()