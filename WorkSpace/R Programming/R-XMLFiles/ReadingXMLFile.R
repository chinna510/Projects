
# Load the packages required to read XML files.
library("XML")
library("methods")


parsingFile <- xmlParse(file = "/home/bizruntime/Chinna/BizRuntime/DataSamples/rinput.xml")

print(parsingFile)

rootn <- xmlRoot(parsingFile)

re <- xmlToList(parsingFile)
print(re)


# Root Of the File
print(rootn[1])

size <- xmlSize(rootn)
print(size)



# Exract the root node form the xml file.
rootnode <- xmlRoot(parsingFile)

# Get the first element of the first node.
print(rootnode[[1]][[1]])

# Get the fifth element of the first node.
print(rootnode[[1]][[5]])

# Get the second element of the third node.
print(rootnode[[3]][[2]])
