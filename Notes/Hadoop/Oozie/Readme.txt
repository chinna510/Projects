1.pre requirement.
	1.1.java 7 
	1.2.maven above 3
	1.3.hadoop installation

2.Sqoop install
        2.1.Downloade latest sqoop.hadoop.bin.XXX.tar.gz
        2.2.Extract sudo tar -xvf sqoop file.
        2.3.server/config   
            2.3.1.sqoop.properties.
                   commenloader=copy the path of hadoop lib/share jar 
example.
	common.loader=${catalina.base}/lib,${catalina.base}/lib/*.jar,${catalina.home}/lib,${catalina.home}/lib/*.jar,
	${catalina.home}/../lib/*.jar,/home/bizruntime/hadoop-2.7.2/share/hadoop/common/*.jar,/home/bizruntime/hadoop-2.7.2/share/hadoop/        		common/	lib/	*.jar,
	/home/bizruntime/hadoop-2.7.2/share/hadoop/yarn/*.jar,/home/bizruntime/hadoop-2.7.2/share/hadoop/yarn/lib/*.jar,
	/home/bizruntime/hadoop-2.7.2/share/hadoop/mapreduce/*.jar,/home/bizruntime/hadoop-2.7.2/share/hadoop/mapreduce/lib/*.jar,
	/home/bizruntime/hadoop-2.7.2/share/hadoop/hdfs/*.jar,/home/bizruntime/hadoop-2.7.2/share/hadoop/hdfs/lib/*.jar,
	/home/bizruntime/hadoop-2.7.2/apache-hive-2.0.0-bin/lib/*.jar,/home/bizruntime/hadoop-2.7.2/share/hadoop/httpfs/tomcat/lib/*.jar,
	/home/bizruntime/hadoop-2.7.2/share/hadoop/tools/lib/*.jar,/home/bizruntime/hadoop-2.7.2/share/hadoop/kms/tomcat/lib/*.jar


          2.3.2.sqoop.properties.
                   set correct Jdbc Repository path.
                   set hadoop config path  hadoop/etc/hadoop/
        2.4.server/lib.
              downloaded jdbc-mysql connector amd add sqoop server lib folder.
        2.5.check configuration properly once.
3.sqoop tool/ server verification.
             sqoop/bin$ ./sqoop2-tool verify  ==>verification successfull your config is correct run server.
             
4.hadoop hdfs/yarn/history server start. hadoop/sbin$ ./start start-dfs.sh/start-ysrn.sh/mr-history-server start historyserver
                    check once hadoop running through jps
5.sqoop-server=>sqoop/bin$ ./sqoop2-server start ==> now check jps.
                                            Bootstrap its running.



6.sqoop client=> make sure sqoop server& client you should run different mechine if you run same mechine server ll showdown default.
                    sqoop/bin$ ./sqoop2-shell =>client started    
                    set server --host <hostname> --port 12000 --webapp sqoop

7.if you want import export through mysql give the priveleges to user

 CREATE USER bizruntime@192.168.1.198 IDENTIFIED BY 'root';
REVOKE ALL PRIVILEGES, GRANT OPTION FROM bizruntime@192.168.1.198;
GRANT SELECT,INSERT,UPDATE,DELETE,LOCK TABLES,EXECUTE ON bizruntime1.* TO bizruntime@192.168.1.198;
FLUSH PRIVILEGES;

now create link,job,and run job

References..

	http://www.bubuko.com/infodetail-1153861.html
	http://ask.csdn.net/questions/202492
	http://stackoverflow.com/questions/34689053/sqoop-does-not-run-a-job
  

