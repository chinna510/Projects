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
				final String INSERTSQL = "select * from Employee";

				con = (Connection) DBConnection.getConnection();
				pstmt = (Statement) con.createStatement();
				rs = pstmt.executeQuery(INSERTSQL);

				while (rs.next()) {

					String fname = rs.getString("fname");
					String lname = rs.getString("lname");
					String phone = rs.getString("phone");
					String city = rs.getString("city");
					String country = rs.getString("country");
					String email = rs.getString("email");
					String credit = rs.getString("credit");
					List<String> list = new ArrayList<String>();
					list.add(fname);
					list.add(lname);
					list.add(phone);
					list.add(city);
					list.add(country);
					list.add(email);
					list.add(credit);
					logger.debug("Waiting for client on port " + serverSocket.getLocalPort() + "...");
					Socket server = serverSocket.accept();
					logger.debug("Just connected to " + server.getRemoteSocketAddress());
					logger.info(server.getLocalPort());
					logger.info(server.getLocalAddress());
					logger.info(server.getInetAddress());
					logger.info(server.isConnected());
					logger.info(server.isBound());
					logger.info(server.isClosed());
					logger.info(server.getSoTimeout());

					server.setReuseAddress(true);
					logger.info(server.getReuseAddress());

					DataInputStream in = new DataInputStream(server.getInputStream());
					logger.debug(in.readUTF());
					DataOutputStream out = new DataOutputStream(server.getOutputStream());
					out.writeUTF("" + list);
					server.close();

				}
			} catch (SocketTimeoutException s) {
				logger.error("Socket timed out!");
				break;
			} catch (IOException e) {
				logger.error(e.getMessage());
				break;
			} catch (ClassNotFoundException e) {
				logger.error(e.getMessage());
			} catch (SQLException e) {
				logger.error(e.getMessage());
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
