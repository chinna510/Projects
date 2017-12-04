<<<<<<< HEAD
package Link1;

import java.util.Scanner;

public class StringReverse {
	public void reverse(){
		
	      String inStr;        // input String
	      int inStrLen;        // length of the input String
	   
	      Scanner in = new Scanner(System.in);
	      System.out.println("Enter a String: ");
	      inStr=in.next();
	   for(int i=inStr.length()-1;i>=0;i--){
		   System.out.print(inStr.charAt(i)+"  ");
	   }
	      
	   }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringReverse str=new StringReverse();
		str.reverse();
	}

}
=======
package Link1;

import java.util.Scanner;

public class StringReverse {
	public void reverse(){
		
	      String inStr;        // input String
	      int inStrLen;        // length of the input String
	   
	      Scanner in = new Scanner(System.in);
	      System.out.println("Enter a String: ");
	      inStr=in.next();
	   for(int i=inStr.length()-1;i>=0;i--){
		   System.out.print(inStr.charAt(i)+"  ");
	   }
	      
	   }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringReverse str=new StringReverse();
		str.reverse();
	}

}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
