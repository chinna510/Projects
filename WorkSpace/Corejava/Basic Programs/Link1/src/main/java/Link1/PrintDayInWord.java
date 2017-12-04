<<<<<<< HEAD
package Link1;

import java.util.Scanner;

public class PrintDayInWord {
	public  void dayInWord() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter Day here");
		int day = sc.nextInt();

		switch (day) {
		case 0:
			System.out.println("SUNDAY");
			break;
		case 1:
			System.out.println("MONDAY");
			break;
		case 2:
			System.out.println("TUESEDAY");
			break;
		case 3:
			System.out.println("WEDNESDAY");
			break;
		case 4:
			System.out.println("THURSDAY");
			break;
		case 5:
			System.out.println("FRIDAY");
			break;
		case 6:
			System.out.println("SATURDAY");
			break;
		
		default:
			System.out.println("Not a valid date");
			break;
		}
}
	public static void main(String[] args) {
		PrintDayInWord piw=new PrintDayInWord();
		piw.dayInWord();
	}
=======
package Link1;

import java.util.Scanner;

public class PrintDayInWord {
	public  void dayInWord() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter Day here");
		int day = sc.nextInt();

		switch (day) {
		case 0:
			System.out.println("SUNDAY");
			break;
		case 1:
			System.out.println("MONDAY");
			break;
		case 2:
			System.out.println("TUESEDAY");
			break;
		case 3:
			System.out.println("WEDNESDAY");
			break;
		case 4:
			System.out.println("THURSDAY");
			break;
		case 5:
			System.out.println("FRIDAY");
			break;
		case 6:
			System.out.println("SATURDAY");
			break;
		
		default:
			System.out.println("Not a valid date");
			break;
		}
}
	public static void main(String[] args) {
		PrintDayInWord piw=new PrintDayInWord();
		piw.dayInWord();
	}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
}