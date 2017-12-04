package com.jcg;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Map.Entry;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import org.apache.log4j.Logger;

public class JarURLConnectionTest {
	static Logger log = Logger.getLogger(JarURLConnectionTest.class);

	private final static String JAR_URL = "jar:file:/home/alok/Alok/WorkspaceEclipse/ScoketPrograming/simple-bean-1.0.jar!/";
	private final static String JAR_FILE_PATH = "file:/C:/Users/ashraf_sarhan/simple-bean-1.0.jar";
	private static URLClassLoader urlClassLoader;
	
	public static void main(String[] args) throws Exception {

		try {

			// Create a URL that refers to a jar file in the file system
			URL FileSysUrl = new URL(JAR_URL);

			// Create a jar URL connection object
			JarURLConnection jarURLConnection = (JarURLConnection) FileSysUrl
					.openConnection();

			// Get the jar file
			JarFile jarFile = jarURLConnection.getJarFile();

			// Get jar file name
			log.info("Jar Name: " + jarFile.getName());

			// When no entry is specified on the URL, the entry name is null
			log.info("\nJar Entry: " + jarURLConnection.getJarEntry());

			// Get the manifest of the jar
			Manifest manifest = jarFile.getManifest();

			// Print the manifest attributes
			log.info("\nManifest file attributes: ");
			for (Entry<Object, Object> entry : manifest.getMainAttributes()
					.entrySet()) {
				log.info(entry.getKey() + ": " + entry.getValue());
			}
			log.info("\nExternal JAR Execution output: ");

			// Get the jar URL which contains target class
			URL[] classLoaderUrls = new URL[] { new URL(JAR_FILE_PATH) };

			// Create a classloader and load the entry point class
			urlClassLoader = new URLClassLoader(classLoaderUrls);

			// Get the main class name (the entry point class)
			String mainClassName = manifest.getMainAttributes().getValue(
					Attributes.Name.MAIN_CLASS);

			// Load the target class
			Class<?> beanClass = urlClassLoader.loadClass(mainClassName);

			// Get the main method from the loaded class and invoke it
			Method method = beanClass.getMethod("sayHello", String[].class);

			// init params accordingly
			String[] params = null;

			// static method doesn't have an instance
			method.invoke(null, (Object) params);

		} catch (MalformedURLException malformedurlexp) {
			log.error(malformedurlexp);
		} catch (IOException io) {
			log.error(io);
		}

	}

}