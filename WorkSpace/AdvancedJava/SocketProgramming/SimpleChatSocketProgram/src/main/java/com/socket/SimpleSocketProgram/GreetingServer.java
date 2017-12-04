package com.socket.SimpleSocketProgram;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class GreetingServer {
	static Logger logger = Logger.getLogger(GreetingServer.class);

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		logger.info("Enter Port number : ");

		int port = sc.nextInt();
		@SuppressWarnings("resource")
		ServerSocket sersock = new ServerSocket(port);
		logger.info("Server  ready for chatting");
		Socket sock = sersock.accept();

		BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));

		OutputStream ostream = sock.getOutputStream();
		PrintWriter pwrite = new PrintWriter(ostream, true);

		InputStream istream = sock.getInputStream();
		BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));

		String receiveMessage, sendMessage;
		while (true) {
			if ((receiveMessage = receiveRead.readLine()) != null) {
				logger.debug(receiveMessage);
			}
			sendMessage = keyRead.readLine();
			pwrite.println(sendMessage);
			pwrite.flush();
		}
	}
}
