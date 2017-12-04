<<<<<<< HEAD
package Link1;

import java.util.Scanner;

public class TestPalindromicPhrase {
	public static void main(String[] args) {
		TestPalindromicPhrase aTestPalindromicPhrase = new TestPalindromicPhrase();

		// aTestPalindromicPhrase.run("Madam, I'm Adam");
		// aTestPalindromicPhrase.run("A man, a plan, a canal - Panama!");

		Scanner in = new Scanner(System.in);
		String phrase;
		System.out.print("Please enter a phrase to test it for palindromic: ");
		phrase = in.nextLine();
		aTestPalindromicPhrase.run(phrase);
	}

	private void run(String phrase) {
		String original = sanitizeString(phrase);
		String reverse = "";
		for (int i = original.length() - 1; i >= 0; i--) {
			reverse += original.charAt(i);
		}

		if (original.toLowerCase().equals(reverse.toLowerCase())) {
			System.out.println(phrase + " is a palindrome ");
		} else {
			System.out.println(phrase + " is not a palindrome");
		}
	}

	private String sanitizeString(String s) {
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case '.':
			case ',':
			case ' ':
			case '-':
			case '\'':
			case '!':
			case '?':
				break;
			default:
				str += s.charAt(i);
				break;
			}
		}
		return str;
	}
}
=======
package Link1;

import java.util.Scanner;

public class TestPalindromicPhrase {
	public static void main(String[] args) {
		TestPalindromicPhrase aTestPalindromicPhrase = new TestPalindromicPhrase();

		// aTestPalindromicPhrase.run("Madam, I'm Adam");
		// aTestPalindromicPhrase.run("A man, a plan, a canal - Panama!");

		Scanner in = new Scanner(System.in);
		String phrase;
		System.out.print("Please enter a phrase to test it for palindromic: ");
		phrase = in.nextLine();
		aTestPalindromicPhrase.run(phrase);
	}

	private void run(String phrase) {
		String original = sanitizeString(phrase);
		String reverse = "";
		for (int i = original.length() - 1; i >= 0; i--) {
			reverse += original.charAt(i);
		}

		if (original.toLowerCase().equals(reverse.toLowerCase())) {
			System.out.println(phrase + " is a palindrome ");
		} else {
			System.out.println(phrase + " is not a palindrome");
		}
	}

	private String sanitizeString(String s) {
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case '.':
			case ',':
			case ' ':
			case '-':
			case '\'':
			case '!':
			case '?':
				break;
			default:
				str += s.charAt(i);
				break;
			}
		}
		return str;
	}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
