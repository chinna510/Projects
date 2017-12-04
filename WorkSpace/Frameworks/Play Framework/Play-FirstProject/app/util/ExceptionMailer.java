package util;

public class ExceptionMailer {
	public static void send(Throwable e) {
		System.out.println("Sending email containing exception " + e);
		}
}
