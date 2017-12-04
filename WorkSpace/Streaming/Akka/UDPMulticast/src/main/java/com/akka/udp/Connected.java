package com.akka.udp;

import java.net.StandardProtocolFamily;
import java.nio.channels.DatagramChannel;

import akka.io.Inet;

public class Connected extends Inet.DatagramChannelCreator {

	@Override
	public DatagramChannel create() throws Exception {
		return DatagramChannel.open(StandardProtocolFamily.INET6);
	}

}