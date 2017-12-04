<<<<<<< HEAD
package Link1;

public class MultiplicationTableOf1To9 {
	/* Prints multiplication table in Java */

	public static void printMultiplicationTable(int tableSize) {
		System.out.println("----------------------------------------------------");

		System.out.print("A*B  |");

		for (int i = 1; i <= tableSize; i++) {

			System.out.print("   "+ i);

		}

		System.out.println();

		System.out.println("-----------------------------------------------------");

		for (int i = 1; i <= tableSize; i++) {

			// print left most column first

			System.out.format("%4d |", i);

			for (int j = 1; j <= tableSize; j++) {

				System.out.format("%4d", i * j);

			}

			System.out.println();

		}
		System.out.println("------------------------------------------");

	}
	public static void twelve(int tableSize1){
		System.out.println("-------------------------------------------------------");

		System.out.format("A*B  |");

		for (int i = 1; i <= tableSize1; i++) {

			System.out.format("%4d", i);

		}

		System.out.println();

		System.out.println("--------------------------------------------------------");

		for (int i = 1; i <= tableSize1; i++) {

			// print left most column first

			System.out.format("%4d |", i);

			for (int j = 1; j <= tableSize1; j++) {

				System.out.format("%4d", i * j);

			}

			System.out.println();

		}
		System.out.println("----------------------------------------------------------");

	}
	

	public static void main(String[] args) {
		int tableSize = 9;
		printMultiplicationTable(tableSize);
		int tableSize1=12;
		twelve(tableSize1);
	}
=======
package Link1;

public class MultiplicationTableOf1To9 {
	/* Prints multiplication table in Java */

	public static void printMultiplicationTable(int tableSize) {
		System.out.println("----------------------------------------------------");

		System.out.print("A*B  |");

		for (int i = 1; i <= tableSize; i++) {

			System.out.print("   "+ i);

		}

		System.out.println();

		System.out.println("-----------------------------------------------------");

		for (int i = 1; i <= tableSize; i++) {

			// print left most column first

			System.out.format("%4d |", i);

			for (int j = 1; j <= tableSize; j++) {

				System.out.format("%4d", i * j);

			}

			System.out.println();

		}
		System.out.println("------------------------------------------");

	}
	public static void twelve(int tableSize1){
		System.out.println("-------------------------------------------------------");

		System.out.format("A*B  |");

		for (int i = 1; i <= tableSize1; i++) {

			System.out.format("%4d", i);

		}

		System.out.println();

		System.out.println("--------------------------------------------------------");

		for (int i = 1; i <= tableSize1; i++) {

			// print left most column first

			System.out.format("%4d |", i);

			for (int j = 1; j <= tableSize1; j++) {

				System.out.format("%4d", i * j);

			}

			System.out.println();

		}
		System.out.println("----------------------------------------------------------");

	}
	

	public static void main(String[] args) {
		int tableSize = 9;
		printMultiplicationTable(tableSize);
		int tableSize1=12;
		twelve(tableSize1);
	}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
}