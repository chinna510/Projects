new_list <- list(matrix(c(12, 13,12,12),nrow = 2,ncol = 2), c(10,22,33,44,55),list("chinna","Rich","JP","Naren"))

names(new_list) <- c("Matrix", "Vector","InnerList")

# Adding Element in Last Index

new_list[4] <- "BigData"

names(new_list) <- c("Matrix", "Vector","InnerList","Technology")

print(new_list)

new_list[4] <- NULL

print(new_list)

new_list[2] <- "BiZRuntime"

print(new_list)


