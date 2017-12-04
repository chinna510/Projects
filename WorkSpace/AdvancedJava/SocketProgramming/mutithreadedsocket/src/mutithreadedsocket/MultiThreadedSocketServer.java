package mutithreadedsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;

public class MultiThreadedSocketServer {
	static Logger log = Logger.getLogger(MultiThreadedSocketServer.class);
	
	ServerSocket myServerSocket;
	boolean ServerOn = true;

	public MultiThreadedSocketServer() {
		try {
			myServerSocket = new ServerSocket(11111);
		} catch (IOException ioe) {
			log.debug("Could not create server socket on port 11111. Quitting.");
			System.exit(-1);
		}

		Calendar now = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		log.debug("It is now : " + formatter.format(now.getTime()));
		while (ServerOn) {
			try {
				Socket clientSocket = myServerSocket.accept();
				ClientServiceThread cliThread = new ClientServiceThread(
						clientSocket);
				cliThread.start();
			} catch (IOException ioe) {
				log.debug("Exception encountered on accept. Ignoring. Stack Trace :");
				ioe.printStackTrace();
			}
		}
		try {
			myServerSocket.close();
			log.debug("Server Stopped");
		} catch (Exception ioe) {
			log.debug("Problem stopping server socket");
			System.exit(-1);
		}
	}

	public static void main(String[] args) {
		new MultiThreadedSocketServer();
	}

	class ClientServiceThread extends Thread {
		Socket myClientSocket;
		boolean m_bRunThread = true;

		public ClientServiceThread() {
			super();
		}

		ClientServiceThread(Socket s) {
			myClientSocket = s;
		}

		public void run() {
			BufferedReader in = null;
			PrintWriter out = null;
			log.debug("Accepted Client Address - "
					+ myClientSocket.getInetAddress().getHostName());
			try {
				in = new BufferedReader(new InputStreamReader(
						myClientSocket.getInputStream()));
				out = new PrintWriter(new OutputStreamWriter(
						myClientSocket.getOutputStream()));
				while (m_bRunThread) {
					String clientCommand = in.readLine();
					log.debug("Client Says :" + clientCommand);

					if (!ServerOn) {
						log.debug("Server has already stopped");
						out.println("Server has already stopped");
						out.flush();
						m_bRunThread = false;
					}
					if (clientCommand.equalsIgnoreCase("quit")) {
						m_bRunThread = false;
						System.out
								.print("Stopping client thread for client : ");
					} else if (clientCommand.equalsIgnoreCase("end")) {
						m_bRunThread = false;
						log.debug("Stopping client thread for client : ");
						ServerOn = false;
					} else {
						out.println("Server Says : " + clientCommand);
						out.flush();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					in.close();
					out.close();
					myClientSocket.close();
					log.debug("...Stopped");
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}

	}
}