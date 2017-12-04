package com.biz.URLClassLoader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import org.apache.log4j.Logger;

public class URLClassLoaderTest {
	Logger log = Logger.getLogger(URLClassLoaderTest.class);

	public static void main(String[] args) throws Exception {

		// Getting the jar URL which contains target class
		URL[] classLoaderUrls = new URL[] { new URL(
				"file:///home/alok/Desktop/simple-bean-1.0.jar") };

		// Create a new URLClassLoader
		URLClassLoader urlClassLoader = new URLClassLoader(classLoaderUrls);

		// Load the target class
		Class<?> beanClass = urlClassLoader.loadClass("com.biz.URLClassLoader.URLClassLoaderTest");

		// Create a new instance from the loaded class
		Constructor<?> constructor = beanClass.getConstructor();
		Object beanObj = constructor.newInstance();

		// Getting a method from the loaded class and invoke it
		Method method = beanClass.getMethod("sayHello");
		method.invoke(beanObj);

	}
	
	public void sayHello() {
		log.info("Hello from loaded Bean class !!!");
	}
}
