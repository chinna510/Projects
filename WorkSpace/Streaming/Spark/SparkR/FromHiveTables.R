Sys.setenv("HADOOP_PREFIX"="/home/bizruntime/Chinna/BizRuntime/InstallationDir/Installations/hadoop-2.7.2")
Sys.setenv("HADOOP_CMD"="/home/bizruntime/Chinna/BizRuntime/InstallationDir/Installations/hadoop-2.7.2/bin/hadoop")
Sys.setenv("HADOOP_STREAMING"="/home/bizruntime/Chinna/BizRuntime/InstallationDir/Installations/hadoop-2.7.2/share/hadoop/tools/lib/hadoop-streaming-2.7.2.jar")
Sys.setenv(SPARK_HOME="/home/bizruntime/Chinna/BizRuntime/InstallationDir/Installations/spark-1.6.1-bin-hadoop2.6")

.libPaths(c(file.path(Sys.getenv("SPARK_HOME"), "R", "lib"), .libPaths()))
library("SparkR")
library("rhdfs")
library("RHive")
sc <- sparkR.init(master = "spark://localhost:7077", appName = "From HiveTables")
hiveContext <- sparkRHive.init(sc)
sql(hiveContext, "CREATE TABLE IF NOT EXISTS default.source (key INT, value STRING)")

sparkR.stop()
