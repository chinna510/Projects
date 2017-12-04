<<<<<<< HEAD
package Link1;

import java.util.Scanner;

public class ProductOfNumbers {

	public static void productOfNumbers() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter number here");
		int number = sc.nextInt();
	
	       int product = 1;
	       for (int i = 1; i <= number; i++) {
	           product = product * i;
	           System.out.print(i+"*");
	       }
	       System.out.println( " = "+product);
	   
	}
public static void main(String[] args) {
	ProductOfNumbers.productOfNumbers();
}
}
=======
package Link1;

import java.util.Scanner;

public class ProductOfNumbers {

	public static void productOfNumbers() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter number here");
		int number = sc.nextInt();
	
	       int product = 1;
	       for (int i = 1; i <= number; i++) {
	           product = product * i;
	           System.out.print(i+"*");
	       }
	       System.out.println( " = "+product);
	   
	}
public static void main(String[] args) {
	ProductOfNumbers.productOfNumbers();
}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
