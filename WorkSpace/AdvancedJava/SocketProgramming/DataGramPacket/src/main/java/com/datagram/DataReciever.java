package com.datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import org.apache.log4j.Logger;

public class DataReciever {
	static Logger logger = Logger.getLogger(DataReciever.class);

	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket(3000);
		byte buf[] = new byte[1024];
		DatagramPacket packet = new DatagramPacket(buf, 1024);
		logger.debug(socket.isConnected());
		socket.setBroadcast(false);
		socket.receive(packet);
		String strRecv = new String(packet.getData(), 0, packet.getLength());
		logger.debug(strRecv);
		socket.close();

	}

}
