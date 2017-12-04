<<<<<<< HEAD
package com.FirstProject;

public class SumOfDigits {
	private void run(int number) {
		String tmp = String.valueOf(number);
		int sum = 0;

		System.out.print("The sum of digits = ");
		for (int i = 0; i < tmp.length(); i++) {
			sum += Character.digit(tmp.charAt(i), 10);
			System.out.print((i == 0 ? "" : " + ") + tmp.charAt(i));
		}
		System.out.print(" = " + sum + "\n");
	}

	public static void main(String[] args) {
		int number = Integer.parseInt(args[0]);
		SumOfDigits su=new SumOfDigits();
		su.run(number);
		
	}

}
=======
package com.FirstProject;

public class SumOfDigits {
	private void run(int number) {
		String tmp = String.valueOf(number);
		int sum = 0;

		System.out.print("The sum of digits = ");
		for (int i = 0; i < tmp.length(); i++) {
			sum += Character.digit(tmp.charAt(i), 10);
			System.out.print((i == 0 ? "" : " + ") + tmp.charAt(i));
		}
		System.out.print(" = " + sum + "\n");
	}

	public static void main(String[] args) {
		int number = Integer.parseInt(args[0]);
		SumOfDigits su=new SumOfDigits();
		su.run(number);
		
	}

}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
