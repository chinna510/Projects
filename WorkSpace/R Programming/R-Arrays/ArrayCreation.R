
new_function <- function(){
  
  vector1 <- c(1,2,3)
  
  vector2 <- c(4,5,6,7,8,9)
  column.names <- c("COL1","COL2","COL3")
  row.names <- c("ROW1","ROW2","ROW3")
  matrix.names <- c("Matrix1","Matrix2")
  
  
  arr <- array(c(vector1, vector2), dim=c(3,3,2),dimnames = list(column.names,row.names,matrix.names)) 
  
  print(arr)
  
}

new_function()

