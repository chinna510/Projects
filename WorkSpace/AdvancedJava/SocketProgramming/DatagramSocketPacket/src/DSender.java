
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.apache.log4j.Logger;

public class DSender {
	static Logger log = Logger.getLogger(DSender.class);

	public static void main(String[] args) throws Exception {
		DatagramSocket ds = new DatagramSocket();
		String str = "hello world";
		byte[] b = str.getBytes();

		InetAddress[] iaa = InetAddress.getAllByName("www.bizruntime.com");
		for (int i = 0; i < iaa.length; i++) {
			log.info("getallnyname: " + iaa[i]);
		}

		InetAddress ia = InetAddress.getByName("localhost");
		log.info(ia);
		DatagramPacket request = new DatagramPacket(b, b.length, ia, 3000);
		ds.send(request);

		byte[] buffer = new byte[1000];
		DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
		ds.receive(reply);
		log.info(new String(reply.getData()));

		ds.close();
	}
}
