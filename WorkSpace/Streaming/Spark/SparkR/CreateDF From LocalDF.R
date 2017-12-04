library(SparkR)

sc <- sparkR.init(master = "local[*]", appName = "DFFromLocal")

sqlContext <- sparkRSQL.init(sc)

df <- data.frame(name = c("chinna", "JP","Richard", "Narendra"), age = c(22,24,23,22))

convertTo <- createDataFrame(sqlContext, df)

print(head(convertTo))

sparkR.stop()