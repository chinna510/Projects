
import java.net.DatagramPacket;

import java.net.DatagramSocket;
import java.net.InetAddress;

import org.apache.log4j.Logger;

public class DReceiver {
	static Logger log = Logger.getLogger(DReceiver.class);

	public static void main(String[] args) throws Exception {
		log.info("Server Started....ready to recieve.....");

		DatagramSocket ds = new DatagramSocket(3000);
		byte[] buf = new byte[1024];

		DatagramPacket dp = new DatagramPacket(buf, 1024);
		ds.receive(dp);

		String strRecv = new String(dp.getData(), 0, dp.getLength());
		log.info(strRecv);

		String s = "message recieved";
		byte[] buf1 = s.getBytes();

		InetAddress ia = InetAddress.getByName("localhost");
		DatagramPacket request = new DatagramPacket(buf1, buf1.length, dp.getAddress(), dp.getPort());
		ds.send(request);

		ds.close();
	}
}
