<<<<<<< HEAD
package Link1;

import java.util.Scanner;

public class SumAndAverage {
	public static void sumAndAverage() {
		int sum = 0;
		double average=0;
		
			Scanner sc = new Scanner(System.in);
			System.out.println("enter lowerbound  here");
			int lowerbound = sc.nextInt();
			System.out.println("enter upperbound here");
			int upperbound = sc.nextInt();
		int count=0;
		for (int number = lowerbound; number <= upperbound; ++number) {
			
			sum += number;
			++count;
			average =(double) sum / count;
			
				}
		
		System.out.println("sum is =" + sum);
		System.out.println("average is =" + average);

	}
	public static void main(String[] args) {
		SumAndAverage.sumAndAverage();
	}
}
=======
package Link1;

import java.util.Scanner;

public class SumAndAverage {
	public static void sumAndAverage() {
		int sum = 0;
		double average=0;
		
			Scanner sc = new Scanner(System.in);
			System.out.println("enter lowerbound  here");
			int lowerbound = sc.nextInt();
			System.out.println("enter upperbound here");
			int upperbound = sc.nextInt();
		int count=0;
		for (int number = lowerbound; number <= upperbound; ++number) {
			
			sum += number;
			++count;
			average =(double) sum / count;
			
				}
		
		System.out.println("sum is =" + sum);
		System.out.println("average is =" + average);

	}
	public static void main(String[] args) {
		SumAndAverage.sumAndAverage();
	}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
