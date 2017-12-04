package com.biz.URLEncoder;

import java.io.UnsupportedEncodingException;
import java.net.*;

import org.apache.log4j.Logger;

public class EncodeTest {
	static Logger log = Logger.getLogger(EncodeTest.class);
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println(URLEncoder.encode("This string has spaces", "UTF-8"));
		System.out.println(URLEncoder.encode("This*string*has*asterisks","UTF-8"));
		System.out.println(URLEncoder.encode("This%string%has%percent%signs", "UTF-8"));
		System.out.println(URLEncoder.encode("This+string+has+pluses", "UTF-8"));
		System.out.println(URLEncoder.encode("This/string/has/slashes", "UTF-8"));
		System.out.println(URLEncoder.encode("This\\string\"has\"quote\"marks","UTF-8"));
		System.out.println(URLEncoder.encode("This:string:has:colons", "UTF-8"));
		System.out.println(URLEncoder.encode("This~string~has~tildes", "UTF-8"));
		System.out.println(URLEncoder.encode("This(string)has(parentheses)","UTF-8"));
		System.out.println(URLEncoder.encode("This.string.has.periods", "UTF-8"));
		System.out.println(URLEncoder.encode("This=string=has=equals=signs","UTF-8"));
		System.out.println(URLEncoder.encode("This&string&has&ampersands","UTF-8"));
	}
}