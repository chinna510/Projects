# Using =
var.1= c(1,2,3)

# Using LeftForward <-

var.2 <- c("Biz","Runtime")

# Using Right Forward ->

c('a','b','c') -> var.3

print(var.1)

cat(var.1,"\n")

print(var.2)

cat(var.2,"\n")

print(var.3)

# It will Combine The Strings
cat(var.3,"\n")

# List All of The Variables In the Current WorkSpace
print(ls())
cat("List Of Variables : ",ls())

print(ls(pattern = "var"))

print(ls(all.names = TRUE))

v= 1:100
print(v)
