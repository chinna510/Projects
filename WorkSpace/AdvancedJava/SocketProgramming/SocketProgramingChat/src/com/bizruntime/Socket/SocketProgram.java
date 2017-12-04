package com.bizruntime.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class SocketProgram {
	static PrintStream output;
	static InputStreamReader ir;
	static BufferedReader br;
	static Scanner scan=new Scanner(System.in);
	static Logger log = Logger.getLogger(SocketProgram.class);
	public static void main(String[] args) throws UnknownHostException,
			IOException {
		SocketProgram s = new SocketProgram();
	/*System.out.println("Enter Your name : ");
		String name=scan.next();*/
		s.run();
		//s.run();
	}

	private void run() throws UnknownHostException, IOException 
	{
		Socket s = new Socket("192.168.1.22", 11111);

		output = new PrintStream(s.getOutputStream());
		output.println(s.getInetAddress() + " at PortNumber " + s.getPort() + " says  : Hello Server");

		ir = new InputStreamReader(s.getInputStream());
		br = new BufferedReader(ir);

		while(s.isConnected()){
			String msg = br.readLine();
			log.info(msg);

			String reply=scan.nextLine();
			output.println(reply);
			
			if(reply.equals("bye")){
				s.close();
			}
		}
	}
}
