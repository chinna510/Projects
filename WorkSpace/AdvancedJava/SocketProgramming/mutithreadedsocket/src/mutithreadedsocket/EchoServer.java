package mutithreadedsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

public class EchoServer {
	static Logger log = Logger.getLogger(EchoServer.class);

	 public static void main(String[] args) throws Exception {
		    ServerSocket m_ServerSocket = new ServerSocket(12111);
		    int id = 0;
		    while (true) {
		      Socket clientSocket = m_ServerSocket.accept();
		      ClientServiceThread cliThread = new ClientServiceThread(clientSocket, id++);
		      cliThread.start();
		    }
		  }
		}

		class ClientServiceThread extends Thread {
			static Logger log = Logger.getLogger(ClientServiceThread.class);

		  Socket clientSocket;
		  int clientID = -1;
		  boolean running = true;

		  ClientServiceThread(Socket s, int i) {
		    clientSocket = s;
		    clientID = i;
		  }

		  public void run() {
		    log.debug("Accepted Client : ID - " + clientID + " : Address - "
		        + clientSocket.getInetAddress().getHostName());
		    try {
		      BufferedReader   in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		      PrintWriter   out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
		      while (running) {
		        String clientCommand = in.readLine();
		        log.debug("Client Says :" + clientCommand);
		        if (clientCommand.equalsIgnoreCase("quit")) {
		          running = false;
		          System.out.print("Stopping client thread for client : " + clientID);
		        } else {
		          out.println(clientCommand);
		          out.flush();
		        }
		      }
		    } catch (IOException io) {
		    	log.error(io);
		    }
		  }
}
