package com.jcg.cl;

import java.io.InputStream;

public class JavaClassLoaderTest extends ClassLoader {

	public static void main(String args[]) throws Exception {
		JavaClassLoaderTest javaClassLoader = new JavaClassLoaderTest();
		javaClassLoader.load();

	}

	public void load() throws Exception {

		// create FileInputStream object
		InputStream fileInputStream = this.getClass().getClassLoader().getResourceAsStream("ClassLoaderInput.class");

		/*
		 * Create byte array large enough to hold the content of the file. Use
		 * fileInputStream.available() to determine size of the file in bytes.
		 */
		byte rawBytes[] = new byte[fileInputStream.available()];

		/*
		 * To read content of the file in byte array, use int read(byte[]
		 * byteArray) method of java FileInputStream class.
		 */
		fileInputStream.read(rawBytes);

		// Load the target class
		Class<?> regeneratedClass = this.defineClass(rawBytes, 0, rawBytes.length);

		// Getting a method from the loaded class and invoke it
		regeneratedClass.getMethod("printString", null).invoke(regeneratedClass.newInstance(), null);
	}

}
