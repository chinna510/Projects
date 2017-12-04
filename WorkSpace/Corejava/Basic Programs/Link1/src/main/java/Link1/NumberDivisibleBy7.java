<<<<<<< HEAD
package Link1;

import java.util.Scanner;

public class NumberDivisibleBy7 {

	public void count() {
		int sum = 0;
		double average = 0;

		Scanner sc = new Scanner(System.in);
		System.out.println("enter lowerbound  here");
		int lowerbound = sc.nextInt();
		System.out.println("enter upperbound here");
		int upperbound = sc.nextInt();
		int number = lowerbound;
		int count = 0;
		for (number = lowerbound; number <= upperbound; ++number) {
			
			if ((number % 7) == 0) {

				sum += number;
				++count;
				average = (double)sum / count;
			}
		}

		System.out.println("sum of numbers divisible by 7 between "
				+ lowerbound + " and " + upperbound + " is= " + +sum);
		System.out.println("average is =" + average);
		System.out.println("count= " + count);

	}
public static void main(String[] args) {
	
	
	NumberDivisibleBy7 div=new NumberDivisibleBy7();
	div.count();
}
}
=======
package Link1;

import java.util.Scanner;

public class NumberDivisibleBy7 {

	public void count() {
		int sum = 0;
		double average = 0;

		Scanner sc = new Scanner(System.in);
		System.out.println("enter lowerbound  here");
		int lowerbound = sc.nextInt();
		System.out.println("enter upperbound here");
		int upperbound = sc.nextInt();
		int number = lowerbound;
		int count = 0;
		for (number = lowerbound; number <= upperbound; ++number) {
			
			if ((number % 7) == 0) {

				sum += number;
				++count;
				average = (double)sum / count;
			}
		}

		System.out.println("sum of numbers divisible by 7 between "
				+ lowerbound + " and " + upperbound + " is= " + +sum);
		System.out.println("average is =" + average);
		System.out.println("count= " + count);

	}
public static void main(String[] args) {
	
	
	NumberDivisibleBy7 div=new NumberDivisibleBy7();
	div.count();
}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
