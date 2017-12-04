<<<<<<< HEAD
package Link1;

import java.util.Scanner; // Needed to use Scanner for input
import java.io.File; // Needed to use File
import java.io.FileNotFoundException; // Needed for file operation

public class FileScanner {
	public static void main(String[] args) throws FileNotFoundException {
		int num1;
		double num2;
		String name;

		File text = new File("in.txt");

		// Creating Scanner instnace to read File in Java
		Scanner file = new Scanner(text);

		// Reading each line of file using Scanner class
		num1 = 0;
		if (file.hasNextInt()) {
			num1 = file.nextInt();
		}

		num2 = 0.0;
		if (file.hasNextDouble()) {
			num2 = file.nextDouble();
		}
		file.nextLine();
		name = "";
		if (file.hasNext()) {
			name = file.nextLine();
		}
		System.out.println("The integer read is = " + num1);
		System.out.println("The floating point number read is = " + num2);
		System.out.println("The String read is = " + name);
		System.out.println("Hi!, the sum of  " + num1 + " and " + num2
				+ " is = " + (num1 + num2));

		file.close();
	}
=======
package Link1;

import java.util.Scanner; // Needed to use Scanner for input
import java.io.File; // Needed to use File
import java.io.FileNotFoundException; // Needed for file operation

public class FileScanner {
	public static void main(String[] args) throws FileNotFoundException {
		int num1;
		double num2;
		String name;

		File text = new File("in.txt");

		// Creating Scanner instnace to read File in Java
		Scanner file = new Scanner(text);

		// Reading each line of file using Scanner class
		num1 = 0;
		if (file.hasNextInt()) {
			num1 = file.nextInt();
		}

		num2 = 0.0;
		if (file.hasNextDouble()) {
			num2 = file.nextDouble();
		}
		file.nextLine();
		name = "";
		if (file.hasNext()) {
			name = file.nextLine();
		}
		System.out.println("The integer read is = " + num1);
		System.out.println("The floating point number read is = " + num2);
		System.out.println("The String read is = " + name);
		System.out.println("Hi!, the sum of  " + num1 + " and " + num2
				+ " is = " + (num1 + num2));

		file.close();
	}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
}