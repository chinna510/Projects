<<<<<<< HEAD
package Link1;

import java.util.Scanner;

public class GradesAverage {
	private final int LOWEST_GRADE = 0;
	private final int HIGHEST_GRADE = 100;

	// student's grades
	private int[] grades;

	private Scanner in;

	public static void main(String[] args) {
		GradesAverage aGradesAverage = new GradesAverage();
		aGradesAverage.in = new Scanner(System.in);

		System.out.print("Enter the number of students: ");
		int numStudents = aGradesAverage.in.nextInt();

		aGradesAverage.run(numStudents);
	}

	private void run(int numStudents) {
		if (numStudents <= 0) {
			System.out.println("Invalid number of students.");
			return;
		}
		grades = new int[numStudents];

		double sum = 0;
		int i = 0;
		while (i < numStudents) {
			System.out.printf("Enter the grade for student %1$d: ", (i + 1));
			int grade = in.nextInt();

			// chek if grade is between 0 and 100
			if ((grade >= LOWEST_GRADE) && (grade <= HIGHEST_GRADE)) {
				grades[i] = grade;
				sum += grade;
				i++;
				continue;
			}
			System.out.println("Invalid grade, try again...");
		}
		System.out.printf("The average is %1$.2f\n", (sum / numStudents));
	}
}
=======
package Link1;

import java.util.Scanner;

public class GradesAverage {
	private final int LOWEST_GRADE = 0;
	private final int HIGHEST_GRADE = 100;

	// student's grades
	private int[] grades;

	private Scanner in;

	public static void main(String[] args) {
		GradesAverage aGradesAverage = new GradesAverage();
		aGradesAverage.in = new Scanner(System.in);

		System.out.print("Enter the number of students: ");
		int numStudents = aGradesAverage.in.nextInt();

		aGradesAverage.run(numStudents);
	}

	private void run(int numStudents) {
		if (numStudents <= 0) {
			System.out.println("Invalid number of students.");
			return;
		}
		grades = new int[numStudents];

		double sum = 0;
		int i = 0;
		while (i < numStudents) {
			System.out.printf("Enter the grade for student %1$d: ", (i + 1));
			int grade = in.nextInt();

			// chek if grade is between 0 and 100
			if ((grade >= LOWEST_GRADE) && (grade <= HIGHEST_GRADE)) {
				grades[i] = grade;
				sum += grade;
				i++;
				continue;
			}
			System.out.println("Invalid grade, try again...");
		}
		System.out.printf("The average is %1$.2f\n", (sum / numStudents));
	}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
