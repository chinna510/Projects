# Create a vector as input.
data <- c("East","West","East","North","North","East","West","West","West","East","North")

print(data)

new_factor <- factor(data)

print(new_factor)

height <- c(5, 5.2, 5.6,5.3,6.0, 4.8)

weight <- c(65,80,56,78,90,46)

gender <- c("Male","Female","Male","Female","Male","Male")

dataframe <- data.frame(height,weight,gender)

print(dataframe)

factors <- factor(dataframe$gender)

print(factors)
