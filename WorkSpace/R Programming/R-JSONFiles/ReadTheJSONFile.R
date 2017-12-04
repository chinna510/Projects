
library("rjson")

result <- fromJSON(file = "/home/bizruntime/Chinna/BizRuntime/DataSamples/rJson.json")

print(result)


# Convert To DataFrames 
JsonToDf <- as.data.frame(result)

print(JsonToDf)

