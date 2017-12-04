package com.biz.serversocket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class ServerSocketProgram {

	PrintStream output;
	InputStreamReader ir;
	BufferedReader br;
	Scanner scan = new Scanner(System.in);
	static Logger log = Logger.getLogger(ServerSocketProgram.class);

	public static void main(String[] args) throws UnknownHostException,
			IOException {
		ServerSocketProgram ss = new ServerSocketProgram();
		ss.run();
	}

	private void run() throws UnknownHostException, IOException {
		ServerSocket sserver = new ServerSocket(8089);
		Socket s = sserver.accept();

		ir = new InputStreamReader(s.getInputStream());
		br = new BufferedReader(ir);
		while (s.isConnected()) {
			String msg = br.readLine();
			log.info(msg);

			output = new PrintStream(s.getOutputStream());
			//output.println("Welcome Client -(" + s.getInetAddress() + ")");
			
			String reply=scan.nextLine();
			output.println("Server : "+reply);
		}
	}
}
