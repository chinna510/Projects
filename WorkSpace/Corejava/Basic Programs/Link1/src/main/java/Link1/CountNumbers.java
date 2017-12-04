<<<<<<< HEAD
package Link1;

import java.util.Scanner;

public class CountNumbers {
	public  void count(){
		int sum = 0;
		double average = 0;

		Scanner sc = new Scanner(System.in);
		System.out.println("enter lowerbound  here");
		int lowerbound = sc.nextInt();
		System.out.println("enter upperbound here");
		int upperbound = sc.nextInt();
		int number = lowerbound;
		int count=0;
		System.out.println("lowerbound is = " + lowerbound);
		System.out.println("upperbound is = " + upperbound);
		do {
			sum += number;
			++number;
			++count;
			average = ((double)sum / count);
		} while (number <= upperbound);
		System.out.println("sum is =" + sum);
		System.out.println("average is =" + average);
		System.out.println("count in between " + lowerbound + " and "
				+ upperbound + " is= " + count);

	}
	public static void main(String[] args) {
		
		CountNumbers cou=new CountNumbers();
		cou.count();
	}
}
=======
package Link1;

import java.util.Scanner;

public class CountNumbers {
	public  void count(){
		int sum = 0;
		double average = 0;

		Scanner sc = new Scanner(System.in);
		System.out.println("enter lowerbound  here");
		int lowerbound = sc.nextInt();
		System.out.println("enter upperbound here");
		int upperbound = sc.nextInt();
		int number = lowerbound;
		int count=0;
		System.out.println("lowerbound is = " + lowerbound);
		System.out.println("upperbound is = " + upperbound);
		do {
			sum += number;
			++number;
			++count;
			average = ((double)sum / count);
		} while (number <= upperbound);
		System.out.println("sum is =" + sum);
		System.out.println("average is =" + average);
		System.out.println("count in between " + lowerbound + " and "
				+ upperbound + " is= " + count);

	}
	public static void main(String[] args) {
		
		CountNumbers cou=new CountNumbers();
		cou.count();
	}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
