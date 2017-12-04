package com.javacodegeeks.snippets.URLConnection;

import java.io.IOException;
import java.net.URI;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.Collection;

public abstract class URLConnectionHelper {
	public abstract Collection<String> getSupportedProtocols();

	public abstract URLConnection openConnection(URI location) throws IOException;

	public abstract URLStreamHandler newStreamHandler() throws IOException;
}
