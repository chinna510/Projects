package com.biz.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class ClientSide {
	static Logger log = Logger.getLogger(ClientSide.class);

	private Socket clientSocket;
	private BufferedReader input;
	private PrintStream output;
	private Scanner sc = new Scanner(System.in);

	private void run() {
		try {
			clientSocket = new Socket("localhost", 41121);

			output = new PrintStream(clientSocket.getOutputStream());

			output.println("Hello Server");

			input = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));

			while (clientSocket.isConnected()) {
				String message = input.readLine();
				log.info("Server: " + message);

				String reply = sc.nextLine();
				output.println(reply);
			}

		} catch (UnknownHostException unhost) {
			log.error(unhost);
		} catch (IOException io) {
			log.error(io);
		}
	}

	public static void main(String[] args) {
		ClientSide client = new ClientSide();
		client.run();
	}
}
