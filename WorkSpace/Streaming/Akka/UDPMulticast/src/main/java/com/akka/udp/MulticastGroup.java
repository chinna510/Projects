package com.akka.udp;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;

import akka.io.Inet;

public class MulticastGroup extends Inet.AbstractSocketOptionV2 {

	private String address;
	private String interf;

	public MulticastGroup(String address, String interf) {
		this.address = address;
		this.interf = interf;
	}

	@Override
	public void afterBind(DatagramSocket s) {
		try {
			InetAddress group = InetAddress.getByName(address);
			NetworkInterface networkInterface = NetworkInterface.getByName(interf);
			s.getChannel().join(group, networkInterface);
		} catch (Exception ex) {
			System.out.println("Unable to join multicast group.");
		}
	}

}
