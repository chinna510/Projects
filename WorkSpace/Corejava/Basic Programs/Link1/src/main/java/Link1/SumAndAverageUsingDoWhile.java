<<<<<<< HEAD
package Link1;

import java.util.Scanner;

public class SumAndAverageUsingDoWhile {

	public static void SumAndAverageUsingDoWhile() {
		int sum = 0;
		double average = 0;
		int count = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter lowerbound  here");
		int lowerbound = sc.nextInt();
		System.out.println("enter upperbound here");
		int upperbound = sc.nextInt();
		int number = lowerbound;

		do {
			sum += number;
			++number;
			++count;
			average = ((double)sum / count);
		} while (number <= upperbound);
		System.out.println("sum is =" + sum);
		System.out.println("average is =" + average);

	}public static void main(String[] args) {
		SumAndAverageUsingDoWhile.SumAndAverageUsingDoWhile();
	}

}
=======
package Link1;

import java.util.Scanner;

public class SumAndAverageUsingDoWhile {

	public static void SumAndAverageUsingDoWhile() {
		int sum = 0;
		double average = 0;
		int count = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter lowerbound  here");
		int lowerbound = sc.nextInt();
		System.out.println("enter upperbound here");
		int upperbound = sc.nextInt();
		int number = lowerbound;

		do {
			sum += number;
			++number;
			++count;
			average = ((double)sum / count);
		} while (number <= upperbound);
		System.out.println("sum is =" + sum);
		System.out.println("average is =" + average);

	}public static void main(String[] args) {
		SumAndAverageUsingDoWhile.SumAndAverageUsingDoWhile();
	}

}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
