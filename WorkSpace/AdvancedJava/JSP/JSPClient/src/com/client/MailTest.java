package com.client;

import java.io.*;
import sun.net.*;
import sun.net.smtp.*;

public class MailTest {
	public static void main(String[] args) throws Exception {
		SmtpClient client = new SmtpClient("mail.lyricnote.com");
		client.from("chinnarao0510@gmail.com");
		client.to("chinna.rao@bizruntime.com");
		PrintStream out = client.startMessage();
		out.println("SUBJECT: Mail test");
		out.println("This is a test of the mail system");
		out.println("This is only a test");
		out.println("Beeeeeeeeeeeeeeeeeeeeeeeep");
		out.println("This concludes the test of the mail system");
		client.closeServer();
	}
}