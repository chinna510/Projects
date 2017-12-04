package com.biz.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

public class DatagramClient {
	static Logger log = Logger.getLogger(DatagramClient.class);

	private InetAddress hostaddress;

	private void run() {
		try {
			DatagramSocket ds = new DatagramSocket();

			byte[] buf = new byte[1000];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);

			hostaddress = InetAddress.getByName("localhost");

			while (true) {
				BufferedReader input = new BufferedReader(
						new InputStreamReader(System.in));
				String message = input.readLine();

				if (message.equals("bye"))
					break;

				String outString = "Client say: " + message;
				buf = outString.getBytes();

				DatagramPacket out = new DatagramPacket(buf, buf.length,
						hostaddress, 9999);
				ds.send(out);

				ds.receive(dp);
				String rcvd = "rcvd from " + dp.getAddress() + ", "
						+ dp.getPort() + ": "
						+ new String(dp.getData(), 0, dp.getLength());
				System.out.println(rcvd);

			}

		} catch (SocketException se) {
			log.error(se);
		} catch (UnknownHostException unhost) {
			log.error(unhost);
		} catch (IOException io) {
			log.error(io);
		}
	}

	public static void main(String[] args) {

		DatagramClient dc = new DatagramClient();
		dc.run();
	}

}
