package com.biz.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class ServerSide {
	static Logger log = Logger.getLogger(ServerSide.class);

	private ServerSocket serverSocket;
	private Socket acceptSocket;
	private BufferedReader input;
	private PrintStream output;
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		ServerSide server = new ServerSide();
		server.run();
	}

	private void run() {

		try {
			serverSocket = new ServerSocket(41121);

			acceptSocket = serverSocket.accept();

			output = new PrintStream(acceptSocket.getOutputStream());

			input = new BufferedReader(new InputStreamReader(
					acceptSocket.getInputStream()));

			while (acceptSocket.isConnected()) {
				String message = input.readLine();
				log.info("Client: "+message);
				
				String reply = sc.nextLine();
				output.println(reply);
			}
			
			/*if (message != null) {
				output.println("welcome");
			}*/
		} catch (IOException io) {
			log.error(io);
		}
	}

}
