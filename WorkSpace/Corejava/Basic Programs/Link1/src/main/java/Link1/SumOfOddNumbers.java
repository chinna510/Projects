<<<<<<< HEAD
package Link1;

import java.util.Scanner;

public class SumOfOddNumbers {

	public static void sumOfOddNumbers() {
		int sum = 0;
		double average = 0;

		Scanner sc = new Scanner(System.in);
		System.out.println("enter lowerbound  here");
		int lowerbound = sc.nextInt();
		System.out.println("enter upperbound here");
		int upperbound = sc.nextInt();
		int number = lowerbound;
		for (number = lowerbound; number <= upperbound; ++number) {
			if (number % 2 == 1) {

				sum += number;
				average = (sum / upperbound);
			}
		
		}

		System.out.println("sum of odd numbers between " + lowerbound + " and "
				+ upperbound + " is= " + +sum);
		System.out.println("average is =" + average);

	}
public static void main(String[] args) {
	SumOfOddNumbers.sumOfOddNumbers();
}
}
=======
package Link1;

import java.util.Scanner;

public class SumOfOddNumbers {

	public static void sumOfOddNumbers() {
		int sum = 0;
		double average = 0;

		Scanner sc = new Scanner(System.in);
		System.out.println("enter lowerbound  here");
		int lowerbound = sc.nextInt();
		System.out.println("enter upperbound here");
		int upperbound = sc.nextInt();
		int number = lowerbound;
		for (number = lowerbound; number <= upperbound; ++number) {
			if (number % 2 == 1) {

				sum += number;
				average = (sum / upperbound);
			}
		
		}

		System.out.println("sum of odd numbers between " + lowerbound + " and "
				+ upperbound + " is= " + +sum);
		System.out.println("average is =" + average);

	}
public static void main(String[] args) {
	SumOfOddNumbers.sumOfOddNumbers();
}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
