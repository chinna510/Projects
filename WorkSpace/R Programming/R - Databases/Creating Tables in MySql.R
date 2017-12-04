
conn <- dbConnect(MySQL(), user='root', password ='root', dbname='bizruntime', host='localhost')

create <- dbWriteTable(conn , "employee", mtcars[,], overwrite=TRUE)

