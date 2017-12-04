
Sys.setenv(SPARK_HOME="/usr/local/spark-1.6.1-bin-hadoop2.6")
.libPaths(c(file.path(Sys.getenv("SPARK_HOME"), "R", "lib"), .libPaths()))
library(SparkR)

sc <- sparkR.init(master = "spark://localhost:7077", appName = "SparkInitialization",sparkEnvir = list(spark.driver.memory="2g"))

sqlContext <- sparkRSQL.init(sc)

df <- createDataFrame(sqlContext,faithful)
print(head(df))

sparkR.stop() 