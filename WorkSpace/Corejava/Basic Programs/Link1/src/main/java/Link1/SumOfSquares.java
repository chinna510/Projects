<<<<<<< HEAD
package Link1;

import java.util.Scanner;

public class SumOfSquares {

	public static void sumOfSquares() {
		int sum = 0, count;
		float average = 0;

		Scanner sc = new Scanner(System.in);
		System.out.println("enter lowerbound  here");
		int lowerbound = sc.nextInt();
		System.out.println("enter upperbound here");
		int upperbound = sc.nextInt();
		int number = lowerbound;

		for (number = lowerbound; number <= upperbound; ++number) {
			sum += (number * number);
			if(number < upperbound){
				
			
			System.out.print(number+"*"+number+" + ");
			}
			else if(number==upperbound){
				System.out.print(number+"*"+number);
			}
		}
		System.out.println(" = "+ sum);
		
	}public static void main(String[] args) {
		SumOfSquares.sumOfSquares();
	}
=======
package Link1;

import java.util.Scanner;

public class SumOfSquares {

	public static void sumOfSquares() {
		int sum = 0, count;
		float average = 0;

		Scanner sc = new Scanner(System.in);
		System.out.println("enter lowerbound  here");
		int lowerbound = sc.nextInt();
		System.out.println("enter upperbound here");
		int upperbound = sc.nextInt();
		int number = lowerbound;

		for (number = lowerbound; number <= upperbound; ++number) {
			sum += (number * number);
			if(number < upperbound){
				
			
			System.out.print(number+"*"+number+" + ");
			}
			else if(number==upperbound){
				System.out.print(number+"*"+number);
			}
		}
		System.out.println(" = "+ sum);
		
	}public static void main(String[] args) {
		SumOfSquares.sumOfSquares();
	}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
}