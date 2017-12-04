package com.hive.HiveClient;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.log4j.Logger;

public class PutDataIntoHdfs {
	static Logger logger = Logger.getLogger(OrderBy.class);

	public void test() throws IOException {

		FileSystem hdfs = FileSystem.get(new Configuration());

		// Print the home directory

		logger.info("Home folder -" + hdfs.getHomeDirectory());

		// Create & Delete Directories

		Path workingDir = hdfs.getWorkingDirectory();

		Path newFolderPath = new Path("MyDataFolder");

		newFolderPath = Path.mergePaths(workingDir, newFolderPath);

		if (hdfs.exists(newFolderPath))

		{

			// Delete existing Directory

			hdfs.delete(newFolderPath, true);

			logger.info("Existing Folder Deleted.");

		}

		hdfs.mkdirs(newFolderPath); // Create new Directory

		logger.info("Folder Created.");

		// Copying File from local to HDFS

		Path localFilePath = new Path("/home/bizruntime/input/input.txt");

		Path hdfsFilePath = new Path(newFolderPath + "/user/hive/warehouse/input/input.txt");

		hdfs.copyFromLocalFile(localFilePath, hdfsFilePath);

		logger.info("File copied from local to HDFS.");

		// Copying File from HDFS to local

		localFilePath = new Path("/home/bizruntime/output/output.txt");

		hdfs.copyToLocalFile(hdfsFilePath, localFilePath);

		logger.info("Files copied from HDFS to local.");

		// Creating a file in HDFS

		Path newFilePath = new Path(newFolderPath + "/input/newFile.txt");

		hdfs.createNewFile(newFilePath);

		// Writing data to a HDFS file

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= 5; i++)

		{

			sb.append("Data");

			sb.append(i);

			sb.append("\n");

		}

		byte[] byt = sb.toString().getBytes();

		FSDataOutputStream fsOutStream = hdfs.create(newFilePath);

		fsOutStream.write(byt);

		fsOutStream.close();

		logger.info("Written data to HDFS file.");

		// Reading data From HDFS File

		logger.info("Reading from HDFS file.");

		BufferedReader bfr = new BufferedReader(

				new InputStreamReader(hdfs.open(newFilePath)));

		String str = null;

		while ((str = bfr.readLine()) != null)

		{

			logger.info(str);

		}
	}

	public static void main(String[] args) throws IOException {
		PutDataIntoHdfs put = new PutDataIntoHdfs();
		put.test();
	}

}
