
package com.bizruntime.tez;

import java.text.DecimalFormat;

import org.apache.hadoop.util.ProgramDriver;
public class ExampleDriver {

	private static final DecimalFormat formatter = new DecimalFormat("###.##%");

	public static void main(String argv[]) {
		int exitCode = -1;
		ProgramDriver pgd = new ProgramDriver();
		try {
			pgd.addClass("wordcount", WordCount.class,
					"A native Tez wordcount program that counts the words in the input files.");
			exitCode = pgd.run(argv);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		System.exit(exitCode);
	}

}
