package com.jcg.cl;

import java.lang.reflect.Constructor;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class URLClassLoaderTest {

	public static void main(String[] args) throws Exception {
		
		// Getting the jar URL which contains target class
		URL[] classLoaderUrls = new URL[]{new URL("file:///home/ashraf/Desktop/simple-bean-1.0.jar")};
		
		// Create a new URLClassLoader 
		URLClassLoader urlClassLoader = new URLClassLoader(classLoaderUrls);
		
		// Load the target class
        Class<?> beanClass = urlClassLoader.loadClass("com.jcg.Bean");
        
        // Create a new instance from the loaded class
        Constructor<?> constructor = beanClass.getConstructor();
        Object beanObj = constructor.newInstance();
        
        // Getting a method from the loaded class and invoke it
        Method method = beanClass.getMethod("sayHello");
        method.invoke(beanObj);

	}

}
