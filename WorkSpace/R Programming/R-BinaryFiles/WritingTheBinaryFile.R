
write.table(mtcars,"/home/bizruntime/mtcars.csv", row.names = FALSE, na="", col.names = TRUE, sep = ",")

data <- read.table("/home/bizruntime/mtcars.csv", sep = ",", header = TRUE, nrows = 5)

write.filename = file("/home/bizruntime/out.dat", "wb")

writeBin(colnames(data), write.filename)

writeBin(c(data$cyl,data$am,data$gear), write.filename)

close(write.filename)