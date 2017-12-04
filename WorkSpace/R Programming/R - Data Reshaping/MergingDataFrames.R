library(MASS)

merged.Pima <- merge(x = Pima.te, y = Pima.tr, by.x = c("bp","bmi"), by.y = c("bp","bmi"))

print(merged.Pima)

nrow(merged.Pima)

print(ships)


# Get and print current working directory.
print(getwd())

setwd("/home/bizruntime/R")

print(getwd())
