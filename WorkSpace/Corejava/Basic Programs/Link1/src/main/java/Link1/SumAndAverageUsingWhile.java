<<<<<<< HEAD
package Link1;

import java.util.Scanner;

public class SumAndAverageUsingWhile {
	public static void sumAndAverageUsingWhile() {
		int sum = 0;
		double average = 0;

		Scanner sc = new Scanner(System.in);
		System.out.println("enter lowerbound  here");
		int lowerbound = sc.nextInt();
		System.out.println("enter upperbound here");
		int upperbound = sc.nextInt();
		int number = lowerbound;

		while (number <= upperbound) {
			sum += number;
			++number;
			average = (sum / upperbound);
		}
		System.out.println("sum is =" + sum);
		System.out.println("average is =" + average);

	}
	public static void main(String[] args) {
		SumAndAverageUsingWhile.sumAndAverageUsingWhile();
	}
=======
package Link1;

import java.util.Scanner;

public class SumAndAverageUsingWhile {
	public static void sumAndAverageUsingWhile() {
		int sum = 0;
		double average = 0;

		Scanner sc = new Scanner(System.in);
		System.out.println("enter lowerbound  here");
		int lowerbound = sc.nextInt();
		System.out.println("enter upperbound here");
		int upperbound = sc.nextInt();
		int number = lowerbound;

		while (number <= upperbound) {
			sum += number;
			++number;
			average = (sum / upperbound);
		}
		System.out.println("sum is =" + sum);
		System.out.println("average is =" + average);

	}
	public static void main(String[] args) {
		SumAndAverageUsingWhile.sumAndAverageUsingWhile();
	}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
}