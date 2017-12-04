<<<<<<< HEAD
package Link1;

import java.util.Scanner;

public class CheckEvenOrOdd {
	public void evenOdd() {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter number here");
		int number = sc.nextInt();
		System.out.println("The number is " + number);
		if (number % 2 == 0) {
			System.out.println("Even");
		} else {
			System.out.println("False");
		}
	}

	public static void main(String[] args) {
		CheckEvenOrOdd evenodd=new CheckEvenOrOdd();
		evenodd.evenOdd();
	}
=======
package Link1;

import java.util.Scanner;

public class CheckEvenOrOdd {
	public void evenOdd() {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter number here");
		int number = sc.nextInt();
		System.out.println("The number is " + number);
		if (number % 2 == 0) {
			System.out.println("Even");
		} else {
			System.out.println("False");
		}
	}

	public static void main(String[] args) {
		CheckEvenOrOdd evenodd=new CheckEvenOrOdd();
		evenodd.evenOdd();
	}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
}