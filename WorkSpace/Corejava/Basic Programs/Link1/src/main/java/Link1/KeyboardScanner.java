<<<<<<< HEAD
package Link1;

import java.util.Scanner;

public class KeyboardScanner {
	 public void scan() {
	      int num1;
	      double num2;
	      String name;
	      double sum;
	    
	      // Setup a Scanner called in to scan the keyboard (System.in)
	      Scanner in = new Scanner(System.in);
	      in.next();
	      System.out.print("Enter an integer: ");
	      num1 = in.nextInt();     // use nextInt() to read int
	      System.out.print("Enter a floating point number: ");
	      
	      num2 = in.nextDouble(); 
	      // use nextDouble() to read double
	      System.out.print("Enter your name: ");
	      name = in.nextLine();        // use next() to read String
	   
	      // Display
	      sum=num1+num2;
	      System.out.println("Hi! "+name+" , the sum of "+num1+" and "+num2+" is = "+sum);
	      

	      // Close the input stream
	      in.close();
	   }
public static void main(String[] args) {
	KeyboardScanner ks=new KeyboardScanner();
	ks.scan();
}
}
=======
package Link1;

import java.util.Scanner;

public class KeyboardScanner {
	 public void scan() {
	      int num1;
	      double num2;
	      String name;
	      double sum;
	    
	      // Setup a Scanner called in to scan the keyboard (System.in)
	      Scanner in = new Scanner(System.in);
	      in.next();
	      System.out.print("Enter an integer: ");
	      num1 = in.nextInt();     // use nextInt() to read int
	      System.out.print("Enter a floating point number: ");
	      
	      num2 = in.nextDouble(); 
	      // use nextDouble() to read double
	      System.out.print("Enter your name: ");
	      name = in.nextLine();        // use next() to read String
	   
	      // Display
	      sum=num1+num2;
	      System.out.println("Hi! "+name+" , the sum of "+num1+" and "+num2+" is = "+sum);
	      

	      // Close the input stream
	      in.close();
	   }
public static void main(String[] args) {
	KeyboardScanner ks=new KeyboardScanner();
	ks.scan();
}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
