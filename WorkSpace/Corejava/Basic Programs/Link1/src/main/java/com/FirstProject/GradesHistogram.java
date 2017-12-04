<<<<<<< HEAD
package com.FirstProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GradesHistogram {
	private int[] grades;
	private int[] bins = new int[10];

	public static void main(String[] args) {
		GradesHistogram aGradesHistogram = new GradesHistogram();
		aGradesHistogram.readGrades("grades.in");
		aGradesHistogram.computeHistogram();
		aGradesHistogram.printHistogramHorizontal();
		aGradesHistogram.printHistogramVertical();
	}

	// check grade value
	private void readGrades(String filename) {
		try {
			File text = new File("grades.in");

			// Creating Scanner instnace to read File in Java
			Scanner file = new Scanner(text);
			// read number of students' grades

			int n = file.nextInt();

			// init grades array
			grades = new int[n];

			// read grades
			for (int i = 0; i < n; i++) {
				if (!file.hasNextInt()) {
					continue;
				}
				grades[i] = file.nextInt();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error! File \"grades.in\" not found.");
		}
	}

	private void computeHistogram() {
		for (int i = 0; i < grades.length; i++) {
			int j = (grades[i] == 100) ? 9 : grades[i] / 10;
			bins[j] += 1;
		}
	}

	/**
	 * Print histogram based on the "bins" array.
	 */
	private void printHistogramHorizontal() {
		System.out.println();
		for (int i = 0; i < bins.length; i++) {
			int delta = (i == bins.length - 1) ? 10 : 9;
			System.out.print("  " + (i * 10) + "-" + (i * 10 + delta) + " :");
			for (int j = 0; j < bins[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private void printHistogramVertical() {
		// find out number of rows to output histogram
		int maxBin = bins[0];
		for (int i = 0; i < bins.length; i++) {
			maxBin = (bins[i] > maxBin) ? bins[i] : maxBin;
		}

		// print histogram
		System.out.println();
		for (int i = maxBin; i >= 0; i--) {
			if (i == 0) {
				for (int j = 0; j < bins.length; j++) {
					int delta = (j == bins.length - 1) ? 10 : 9;
					System.out.print(" " + (j * 10) + "-" + (j * 10 + delta));
				}
			} else {
				for (int j = 0; j < bins.length; j++) {
					String str = (bins[j] < i) ? " " : "*";
					System.out.printf("%3s%-2s ", str, " ");
				}
			}
			System.out.println();
		}
	}

}
=======
package com.FirstProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GradesHistogram {
	private int[] grades;
	private int[] bins = new int[10];

	public static void main(String[] args) {
		GradesHistogram aGradesHistogram = new GradesHistogram();
		aGradesHistogram.readGrades("grades.in");
		aGradesHistogram.computeHistogram();
		aGradesHistogram.printHistogramHorizontal();
		aGradesHistogram.printHistogramVertical();
	}

	// check grade value
	private void readGrades(String filename) {
		try {
			File text = new File("grades.in");

			// Creating Scanner instnace to read File in Java
			Scanner file = new Scanner(text);
			// read number of students' grades

			int n = file.nextInt();

			// init grades array
			grades = new int[n];

			// read grades
			for (int i = 0; i < n; i++) {
				if (!file.hasNextInt()) {
					continue;
				}
				grades[i] = file.nextInt();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error! File \"grades.in\" not found.");
		}
	}

	private void computeHistogram() {
		for (int i = 0; i < grades.length; i++) {
			int j = (grades[i] == 100) ? 9 : grades[i] / 10;
			bins[j] += 1;
		}
	}

	/**
	 * Print histogram based on the "bins" array.
	 */
	private void printHistogramHorizontal() {
		System.out.println();
		for (int i = 0; i < bins.length; i++) {
			int delta = (i == bins.length - 1) ? 10 : 9;
			System.out.print("  " + (i * 10) + "-" + (i * 10 + delta) + " :");
			for (int j = 0; j < bins[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private void printHistogramVertical() {
		// find out number of rows to output histogram
		int maxBin = bins[0];
		for (int i = 0; i < bins.length; i++) {
			maxBin = (bins[i] > maxBin) ? bins[i] : maxBin;
		}

		// print histogram
		System.out.println();
		for (int i = maxBin; i >= 0; i--) {
			if (i == 0) {
				for (int j = 0; j < bins.length; j++) {
					int delta = (j == bins.length - 1) ? 10 : 9;
					System.out.print(" " + (j * 10) + "-" + (j * 10 + delta));
				}
			} else {
				for (int j = 0; j < bins.length; j++) {
					String str = (bins[j] < i) ? " " : "*";
					System.out.printf("%3s%-2s ", str, " ");
				}
			}
			System.out.println();
		}
	}

}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
