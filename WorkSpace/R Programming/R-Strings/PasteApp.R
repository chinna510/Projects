
# Syntax

# paste(args , sep ="", collapse ="")

a <- "Hello"
b <- "Welcome"
c <- "to Bizruntime"

print(paste(a,b,c)) # Output ="Hello Welcome to Bizruntime"

print(paste(a,b,c,sep = "-"))  # Output ="Hello-Welcome-to Bizruntime"

print(paste(a,b,c,sep="",collapse = " "))   #Output ="HelloWelcometo Bizruntime"


