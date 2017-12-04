package com.socket.SimpleSocketProgram;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class GreetingServer extends Thread {
	static Logger logger = Logger.getLogger(GreetingServer.class);
	Connection con = null;
	Statement pstmt = null;
	ResultSet rs = null;

	private ServerSocket serverSocket;

	public GreetingServer(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(30000);
		
	}

	public void run() {
		while (true) {
			try {

				logger.debug("LocalPort : " + serverSocket.getLocalPort() );
				
				logger.debug("SocketChannel : " + serverSocket.getChannel() );
				Socket server = serverSocket.accept();
				logger.debug("Just connected to " + server.getRemoteSocketAddress());
				DataInputStream in = new DataInputStream(server.getInputStream());
				logger.debug(in.readUTF());
				DataOutputStream out = new DataOutputStream(server.getOutputStream());
			
				out.writeUTF("Values : ");
				server.close();
			} catch (SocketTimeoutException s) {
				logger.error("Socket timed out!");
				break;
			} catch (IOException e) {
				logger.error(e.getMessage());
				break;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		logger.info("Enter Port Number : ");
		int port = sc.nextInt();
		try {
			Thread t = new GreetingServer(port);
			t.start();
		} catch (IOException e) {
			logger.error(e.getMessage());

		}
	}
}
