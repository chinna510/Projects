<<<<<<< HEAD
package com.FirstProject;

import java.util.Scanner;

public class Hex2Bin {
	private final String[] hexBits = { "0000", "0001", "0010", "0011", "0100",
			"0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100",
			"1101", "1110", "1111" };

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a Hexadecimal string: ");
		String hexStr = in.next();
		
		Hex2Bin h2b = new Hex2Bin();
		if (!h2b.isHex(hexStr)) {
			System.out.printf("Invalid Hexadecimal string \"%1$s\"\n", hexStr);
			return;
		}
		h2b.convertHexToBin(hexStr);
	}

	private boolean isHex(String hexStr) {
		for (int i = 0; i < hexStr.length(); i++) {
			if (0 > Character.digit(hexStr.toLowerCase().charAt(i), 16)) {
				return false;
			}
		}
		return true;
	}

	private void convertHexToBin(String hexStr) {

		System.out.printf("The equivalent binary for hexadecimal %1$s is ",
				hexStr);

		for (int i = 0; i < hexStr.length(); i++) {
			int j = Character.digit(hexStr.toLowerCase().charAt(i), 16);
			System.out.printf("%1$s ", hexBits[j]);
		}
		System.out.println();
	}

}
=======
package com.FirstProject;

import java.util.Scanner;

public class Hex2Bin {
	private final String[] hexBits = { "0000", "0001", "0010", "0011", "0100",
			"0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100",
			"1101", "1110", "1111" };

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a Hexadecimal string: ");
		String hexStr = in.next();
		
		Hex2Bin h2b = new Hex2Bin();
		if (!h2b.isHex(hexStr)) {
			System.out.printf("Invalid Hexadecimal string \"%1$s\"\n", hexStr);
			return;
		}
		h2b.convertHexToBin(hexStr);
	}

	private boolean isHex(String hexStr) {
		for (int i = 0; i < hexStr.length(); i++) {
			if (0 > Character.digit(hexStr.toLowerCase().charAt(i), 16)) {
				return false;
			}
		}
		return true;
	}

	private void convertHexToBin(String hexStr) {

		System.out.printf("The equivalent binary for hexadecimal %1$s is ",
				hexStr);

		for (int i = 0; i < hexStr.length(); i++) {
			int j = Character.digit(hexStr.toLowerCase().charAt(i), 16);
			System.out.printf("%1$s ", hexBits[j]);
		}
		System.out.println();
	}

}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
