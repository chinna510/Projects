new_list <- list(matrix(c(12, 13,12,12),nrow = 2,ncol = 2), c(10,22,33,44,55),list("chinna","Rich","JP","Naren"))

names(new_list) <- c("Matrix", "Vector","InnerList")

print(new_list)

print(new_list[2])

print(new_list$InnerList)
