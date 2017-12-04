<<<<<<< HEAD
package Link1;

public class ReplceNumberWithString {
	public static void replceNumberWithString() {
		int lowerbound = 1;
		int upperbound = 110;
		for (int number = lowerbound; number <= upperbound; ++number) {
				if(number % 11==0){
				
			if(number % 3 ==0){
					System.out.println("coza");
				}
			else if(number%5==0){
				System.out.println("loza");
			}
			else if(number % 7==0){
				System.out.println("woza");
			}else{
				
			
			System.out.println(number);
			}
			} else if (((number % 3) | (number % 5)) == 0) {
				System.out.print("CozaLoza ");
			}	else if (((number % 3) | (number % 7)) == 0) {
					System.out.print("cozaWoza ");

				// Print "Coza" if number is divisible by 3
			} else if (number % 3 == 0) {
				System.out.print("Coza ");

				// Print "Loza" if number is divisible by 5
			} else if (number % 5 == 0) {
				System.out.print("loza ");
			}

			else if (number % 7 == 0) {
				System.out.print("woza ");

			} else if (((number % 3) | (number % 5) | (number % 7)) != 0) {
				System.out.print(" " + number + " ");
			} else {
				System.out.println(" ");
			}
		}
	}

	public static void main(String[] args) {
		ReplceNumberWithString.replceNumberWithString();
	}

}
=======
package Link1;

public class ReplceNumberWithString {
	public static void replceNumberWithString() {
		int lowerbound = 1;
		int upperbound = 110;
		for (int number = lowerbound; number <= upperbound; ++number) {
				if(number % 11==0){
				
			if(number % 3 ==0){
					System.out.println("coza");
				}
			else if(number%5==0){
				System.out.println("loza");
			}
			else if(number % 7==0){
				System.out.println("woza");
			}else{
				
			
			System.out.println(number);
			}
			} else if (((number % 3) | (number % 5)) == 0) {
				System.out.print("CozaLoza ");
			}	else if (((number % 3) | (number % 7)) == 0) {
					System.out.print("cozaWoza ");

				// Print "Coza" if number is divisible by 3
			} else if (number % 3 == 0) {
				System.out.print("Coza ");

				// Print "Loza" if number is divisible by 5
			} else if (number % 5 == 0) {
				System.out.print("loza ");
			}

			else if (number % 7 == 0) {
				System.out.print("woza ");

			} else if (((number % 3) | (number % 5) | (number % 7)) != 0) {
				System.out.print(" " + number + " ");
			} else {
				System.out.println(" ");
			}
		}
	}

	public static void main(String[] args) {
		ReplceNumberWithString.replceNumberWithString();
	}

}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
