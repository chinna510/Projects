<<<<<<< HEAD
package Link1;

import java.util.Scanner;

public class Bin2Decimal {
	public static void main(String[] args) {
		Bin2Decimal aBin2Dec = new Bin2Decimal();

		// aBin2Dec.runTest("1010");
		// aBin2Dec.runTest("1234");

		Scanner in = new Scanner(System.in);
		System.out.print("\nEnter a Binary string: ");
		String bin = in.next();
		aBin2Dec.runTest(bin);
	}

	private void runTest(String binStr) {
		if (!isBin(binStr)) {
			System.out
					.printf("Error: Invalid Binary String \"%1$s\"\n", binStr);
			return;
		}
		System.out.printf(
				"The equivalent decimal number for binary \"%1$s\" is %2$d\n",
				binStr, convertBin2Dec(binStr));
	}


	private static boolean isBin(String binStr) {
		for (int i = 0; i < binStr.length(); i++) {
			if (binStr.charAt(i) == '0') {
				continue;
			}
			else if (binStr.charAt(i) == '1') {
				continue;
			}
			return false;
		}
		return true;
	}

	private int convertBin2Dec(String binStr) {
		int number = 0;
		for (int i = 0; i < binStr.length(); i++) {
			if (binStr.charAt(i) == '0') {
				continue;
			}
			number += Math.pow(2, (binStr.length() - 1 - i));
		}
		return number;
	}

}
=======
package Link1;

import java.util.Scanner;

public class Bin2Decimal {
	public static void main(String[] args) {
		Bin2Decimal aBin2Dec = new Bin2Decimal();

		// aBin2Dec.runTest("1010");
		// aBin2Dec.runTest("1234");

		Scanner in = new Scanner(System.in);
		System.out.print("\nEnter a Binary string: ");
		String bin = in.next();
		aBin2Dec.runTest(bin);
	}

	private void runTest(String binStr) {
		if (!isBin(binStr)) {
			System.out
					.printf("Error: Invalid Binary String \"%1$s\"\n", binStr);
			return;
		}
		System.out.printf(
				"The equivalent decimal number for binary \"%1$s\" is %2$d\n",
				binStr, convertBin2Dec(binStr));
	}


	private static boolean isBin(String binStr) {
		for (int i = 0; i < binStr.length(); i++) {
			if (binStr.charAt(i) == '0') {
				continue;
			}
			else if (binStr.charAt(i) == '1') {
				continue;
			}
			return false;
		}
		return true;
	}

	private int convertBin2Dec(String binStr) {
		int number = 0;
		for (int i = 0; i < binStr.length(); i++) {
			if (binStr.charAt(i) == '0') {
				continue;
			}
			number += Math.pow(2, (binStr.length() - 1 - i));
		}
		return number;
	}

}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
