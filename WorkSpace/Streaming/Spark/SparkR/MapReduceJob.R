
Sys.setenv("HADOOP_PREFIX"="/home/bizruntime/Chinna/BizRuntime/InstallationDir/Installations/hadoop-2.7.2")
Sys.setenv("HADOOP_CMD"="/home/bizruntime/Chinna/BizRuntime/InstallationDir/Installations/hadoop-2.7.2/bin/hadoop")
Sys.setenv("HADOOP_STREAMING"="/home/bizruntime/Chinna/BizRuntime/InstallationDir/Installations/hadoop-2.7.2/share/hadoop/tools/lib/hadoop-streaming-2.7.2.jar")


library(rmr2) 

## map function
map <- function(k,lines) {
  words.list <- strsplit(lines, '\\s') 
  words <- unlist(words.list)
  return( keyval(words, 1) )
}

## reduce function
reduce <- function(word, counts) { 
  keyval(word, sum(counts))
}

wordcount <- function (input, output=NULL) { 
  mapreduce(input=input, output=output, input.format="text", 
            map=map, reduce=reduce)
}


## delete previous result if any
system("$HADOOP_CMD fs -rmr wordcount/out")

## Submit job
hdfs.root <- 'wordcount'
hdfs.data <- file.path(hdfs.root, 'Status.txt') 
hdfs.out <- file.path(hdfs.root, 'out2') 
out <- wordcount(hdfs.data, hdfs.out)

## Fetch results from HDFS
results <- from.dfs(out)

## check top 30 frequent words
results.df <- as.data.frame(results, stringsAsFactors=F) 
colnames(results.df) <- c('word', 'count') 
head(results.df[order(results.df$count, decreasing=T), ], 30)

