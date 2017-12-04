

mysqlconnection = dbConnect(MySQL(), user = 'root', password = 'root', dbname = 'bizruntime',
                            host = 'localhost')

list <- dbListTables(mysqlconnection)

print(list)

#For Querying table
#result <- dbSendQuery(mysqlconnection, "select * from customer")
#data.frame= fetch(result, n=5)
#print(data.frame)

# Query With Filter

filtering <- dbSendQuery(mysqlconnection, "select * from customer where name='chinna'")
data.frame =fetch(filtering, n=-1)
print(data.frame)

# creation Of Table By using DAtaFrame
create <- dbWriteTable(conn , "employee", data.frame[,], overwrite=TRUE)


