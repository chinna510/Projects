package com.client;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

public class JavaMailTest {
	public static void main(String[] args) throws Exception {
		// Create a session with the LyricNote mail host
		Properties props = new Properties();
		props.put("mail.host", "mail.lyricnote.com");
		Session mailSession = Session.getInstance(props, null);
		Address fromUser = new InternetAddress("phanna@lyricnote.com");
		Address toUser = new InternetAddress("phanna@lyricnote.com");
		// Create the message body
		Message body = new MimeMessage(mailSession);
		body.setFrom(fromUser);
		body.setRecipient(Message.RecipientType.TO, toUser);
		body.setSubject("Mail Test");
		body.setContent("This is a test of the mail system\n" + "This is only a test\n"
				+ "Beeeeeeeeeeeeeeeeeeeeeeeeeeeeep\n" + "This concludes the test of the mail system", "text/plain");
		// Send the message
		Transport.send(body);
	}
}