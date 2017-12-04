
mysqlconnection = dbConnect(MySQL(), user = 'root', password = 'root', dbname = 'bizruntime',
                            host = 'localhost')


result <- dbSendQuery(mysqlconnection,
            "insert into customer(id,name)
   values(21, 'Rich')"
)

update <- dbSendQuery(mysqlconnection, "update customer set name='MAni' where name='chinna'")

