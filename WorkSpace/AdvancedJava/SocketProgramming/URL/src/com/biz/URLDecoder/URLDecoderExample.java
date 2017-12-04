package com.biz.URLDecoder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.apache.log4j.Logger;

public class URLDecoderExample {
	static Logger log = Logger.getLogger(URLDecoderExample.class);

	public static void main(String args[]) throws UnsupportedEncodingException {
		log.debug(URLDecoder.decode("special+chars%3A+%26%25*+",
				"UTF-8"));
	}
}
