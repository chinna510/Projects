<<<<<<< HEAD
package Link1;

import java.util.Scanner;

public class HarmonicSeries {
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("enter n value");
		int n=sc.nextInt();
		HarmonicSeries aHarmonicSum = new HarmonicSeries();
		double sumL2R = aHarmonicSum.printLeftToRightSum(n);
		double sumR2L = aHarmonicSum.printRightToLeftSum(n);
		System.out.printf("Difference: " + (sumL2R - sumR2L));
		System.out.println();
	}

	private double printLeftToRightSum(int n) {
		double sum = 0.0;
		for (int i = 1; i <= n; i++) {
			sum += (double) 1 / i;
			System.out.print(1 + "/" + i + " + ");
		}

		System.out.print(" = " + sum);
		System.out.println();

		return sum;
	}

	private double printRightToLeftSum(int n) {
		double sum = 0.0;
		for (int i = n; i >= 1; i--) {
			sum += (double) 1 / i;
			System.out.print(1 + "/" + i + " + ");
		}

		System.out.print(" = " + sum);
		System.out.println();

		return sum;
	}
}
=======
package Link1;

import java.util.Scanner;

public class HarmonicSeries {
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("enter n value");
		int n=sc.nextInt();
		HarmonicSeries aHarmonicSum = new HarmonicSeries();
		double sumL2R = aHarmonicSum.printLeftToRightSum(n);
		double sumR2L = aHarmonicSum.printRightToLeftSum(n);
		System.out.printf("Difference: " + (sumL2R - sumR2L));
		System.out.println();
	}

	private double printLeftToRightSum(int n) {
		double sum = 0.0;
		for (int i = 1; i <= n; i++) {
			sum += (double) 1 / i;
			System.out.print(1 + "/" + i + " + ");
		}

		System.out.print(" = " + sum);
		System.out.println();

		return sum;
	}

	private double printRightToLeftSum(int n) {
		double sum = 0.0;
		for (int i = n; i >= 1; i--) {
			sum += (double) 1 / i;
			System.out.print(1 + "/" + i + " + ");
		}

		System.out.print(" = " + sum);
		System.out.println();

		return sum;
	}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
