
read.file <- file("/home/bizruntime/out.dat", "rb")

column.names <- readBin(read.file, character(),n=3)

print(column.names)

data <- readBin(read.file, integer(),n=30)

print(data)

close(read.file)


# Read the values from 4th byte to 8th byte which represents "cyl".
cyldata = data[4:8]
print(cyldata)


# Read the values form 9th byte to 13th byte which represents "am".
amdata =data[9:13]
print(amdata)

# Read the values form 9th byte to 13th byte which represents "gear".
geardata = data[14:18]
print(geardata)

# Combine all the read values to a dat frame.
finaldata = cbind(cyldata, amdata, geardata)
colnames(finaldata) = column.names
print(finaldata)

