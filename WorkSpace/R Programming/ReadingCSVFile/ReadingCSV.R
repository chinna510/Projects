data <- read.csv("/home/bizruntime/R/input.csv")
print(data)

#Analyzing the CSV File
print(is.data.frame(data))
print(ncol(data))
print(nrow(data))

# Get The Maximum Salary
sal <- max(data$salary)
print(sal)

# Get the details of the person with max salary
getData <- subset(data, salary== max(data$salary))

print(getData)

# Get all the people working in IT department
retval <- subset( data, dept == "IT")
print(retval)

# Get the persons in IT department whose salary is greater than 600
info <- subset(data, salary > 600 & dept == "IT")
print(info)

retval1 <- subset(data, as.Date(start_date) > as.Date("2014-01-01"))

print(retval1)







