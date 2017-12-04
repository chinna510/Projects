package com.biz.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import org.apache.log4j.Logger;

public class DatagramServer {
	static Logger log = Logger.getLogger(DatagramServer.class);
	
	private void run(){
		
		int PORT = 4000;
	    byte[] buf = new byte[1000];
	    DatagramPacket dgp = new DatagramPacket(buf, buf.length);
	    DatagramSocket sk;

	    try {
			sk = new DatagramSocket(PORT);
		
	    log.debug("Server started");
	    while (true) {
	      sk.receive(dgp);
	      String rcvd = new String(dgp.getData(), 0, dgp.getLength()) + ", from address: "
	          + dgp.getAddress() + ", port: " + dgp.getPort();
	      log.debug(rcvd);
	      
	      BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	      String outMessage = stdin.readLine();
	      buf = ("Server say: " + outMessage).getBytes();
	      DatagramPacket out = new DatagramPacket(buf, buf.length, dgp.getAddress(), dgp.getPort());
	      sk.send(out);
	    }
	    } catch (SocketException se) {
			log.error(se);
		} catch (IOException io) {
			log.error(io);
		}
	}
	
	public static void main(String[] args) {

		DatagramServer ds = new DatagramServer();
		ds.run();
	}

}
