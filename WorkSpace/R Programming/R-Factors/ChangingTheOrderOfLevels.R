
data <- c("East","West","East","North","North","East","West","West","West","East","North")
# Create the factors
factor_data <- factor(data)
print(factor_data)

# Apply the factor function with required order of the level.
new_order_data <- factor(factor_data,levels = c("East","West","North"))
print(new_order_data)


# Generating Factor Levels. here 3 is No.OF Levels, 4 is No.Of Replications

v <- gl(3, 4, labels = c("Tampa", "Seattle","Boston"))
print(v)