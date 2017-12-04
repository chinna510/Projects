<<<<<<< HEAD
package Link1;

public class CheckerBoard {
	public void check(){
		for (int i = 1; i <= 7; i++) {
			if(i % 2==0){
				System.out.print(" ");
			}
			for (int j = 1; j <= 7; j++) {
				System.out.print("# ");
				

			}
			
			System.out.println();
		}

	}

	public static void main(String[] args) {
		
		CheckerBoard cb=new CheckerBoard();
		cb.check();
	}

}
=======
package Link1;

public class CheckerBoard {
	public void check(){
		for (int i = 1; i <= 7; i++) {
			if(i % 2==0){
				System.out.print(" ");
			}
			for (int j = 1; j <= 7; j++) {
				System.out.print("# ");
				

			}
			
			System.out.println();
		}

	}

	public static void main(String[] args) {
		
		CheckerBoard cb=new CheckerBoard();
		cb.check();
	}

}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
