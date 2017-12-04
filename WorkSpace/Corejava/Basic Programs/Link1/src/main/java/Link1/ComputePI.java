<<<<<<< HEAD
package Link1;

import java.util.Scanner; // import scanner util

public class ComputePI {

	public static void computePI() {
		Scanner Reader = new Scanner(System.in); // set up the scanner variable

		System.out.print("Enter the number of iterations:");
		int input = Reader.nextInt(); // sets user input

		double sum = 0;
		for (int i = 1; i <= input; i++) {

			double numToAdd = 4 * (1.0 / ((i * 2) - 1));

			if (i % 2 > 0)
				sum = (sum + numToAdd);
			else

				sum = (sum - numToAdd);

			System.out.println("PI is equal to " + sum);

		}
	}

	public static void main(String[] args) {
		ComputePI.computePI();
	}
}
=======
package Link1;

import java.util.Scanner; // import scanner util

public class ComputePI {

	public static void computePI() {
		Scanner Reader = new Scanner(System.in); // set up the scanner variable

		System.out.print("Enter the number of iterations:");
		int input = Reader.nextInt(); // sets user input

		double sum = 0;
		for (int i = 1; i <= input; i++) {

			double numToAdd = 4 * (1.0 / ((i * 2) - 1));

			if (i % 2 > 0)
				sum = (sum + numToAdd);
			else

				sum = (sum - numToAdd);

			System.out.println("PI is equal to " + sum);

		}
	}

	public static void main(String[] args) {
		ComputePI.computePI();
	}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
