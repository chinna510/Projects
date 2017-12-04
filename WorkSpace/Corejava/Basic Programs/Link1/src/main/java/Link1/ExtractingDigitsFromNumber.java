<<<<<<< HEAD
package Link1;

import java.util.Scanner;

public class ExtractingDigitsFromNumber {
	public void extract(){

        int n, m, a, i = 1, counter = 0;
        Scanner s=new Scanner(System.in);
        System.out.println("enter number");
        n = s.nextInt();
        m = n;
        while(n > 0)
        {
            n = n / 10;
            counter++;
        }
        while(m > 0)
        {
            a = m % 10;
            System.out.print(a+",");
            m = m / 10;
            counter--;
        }
	}
    public static void main(String args[]){
    	ExtractingDigitsFromNumber extract=new ExtractingDigitsFromNumber();
    	extract.extract();
    }
    
    }
   
    
=======
package Link1;

import java.util.Scanner;

public class ExtractingDigitsFromNumber {
	public void extract(){

        int n, m, a, i = 1, counter = 0;
        Scanner s=new Scanner(System.in);
        System.out.println("enter number");
        n = s.nextInt();
        m = n;
        while(n > 0)
        {
            n = n / 10;
            counter++;
        }
        while(m > 0)
        {
            a = m % 10;
            System.out.print(a+",");
            m = m / 10;
            counter--;
        }
	}
    public static void main(String args[]){
    	ExtractingDigitsFromNumber extract=new ExtractingDigitsFromNumber();
    	extract.extract();
    }
    
    }
   
    
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
