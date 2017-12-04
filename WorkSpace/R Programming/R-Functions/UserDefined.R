

# Function Creation
f <- function(a){
  
  for(i in 1:a){
    b <- i^i
    print(b)
  }
}



# Calling Function
f(5)

# Create a function with arguments.
new.function <- function(a,b,c) {
  result <- a * b + c
  print(result)
}

# Call the function by position of arguments.
new.function(5,3,11)

# Call the function by names of the arguments.
new.function(a = 11, b = 5, c = 3)


# Lazy Evaluation of Function
# Create a function with arguments.
new.function <- function(a, b) {
  print(a^2)
  print(a)

}

# Evaluate the function without supplying one of the arguments.
new.function(6)


# Calling a Function with Default Argument

new.function <- function(a = 3, b = 6) {
  result <- a * b
  print(result)
}

# Call the function without giving any argument.
new.function()

# Call the function with giving new values of the argument.
new.function(9,5)

#Calling a Function with Argument Values (by position and by name)

# Create a function with arguments.
new.function <- function(a,b,c) {
  result <- a * b + c
  print(result)
}

# Call the function by position of arguments.
new.function(5,3,11)

# Call the function by names of the arguments.
new.function(a = 11, b = 5, c = 3)



