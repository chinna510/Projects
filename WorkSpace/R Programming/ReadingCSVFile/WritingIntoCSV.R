
data <- read.csv("/home/bizruntime/R/input.csv")

retval <- subset(data, as.Date(start_date) > as.Date("2014-01-01"))

# Storing Data into CSV file
newData <- write.csv(retval, "/home/bizruntime/R/output.csv")

retrieve <- read.csv("/home/bizruntime/R/output.csv")
print(retrieve)

# For Removing X column 
write.csv(retval,"output.csv", row.names = FALSE)
newdata <- read.csv("output.csv")
print(newdata)
