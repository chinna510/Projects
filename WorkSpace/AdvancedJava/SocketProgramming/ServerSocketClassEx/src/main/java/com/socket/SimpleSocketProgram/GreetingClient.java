package com.socket.SimpleSocketProgram;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class GreetingClient {
	static Logger logger = Logger.getLogger(GreetingClient.class);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		logger.info("Enter Server name : ");
		String serverName = sc.nextLine();
		logger.info("Enter Port number : ");

		int port = sc.nextInt();

		try {

			logger.debug("Connecting to " + serverName + " on port " + port);
			Socket client = new Socket(serverName, port);
			logger.debug("Just connected to " + client.getRemoteSocketAddress());
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);

			out.writeUTF("Hello from " + client.getLocalSocketAddress());
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);

			logger.debug("Database values are " + in.readUTF());
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
