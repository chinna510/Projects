<<<<<<< HEAD
package Link1;

import java.util.Scanner;

public class CircleComputation {
	 public static void main(String[] args) {
	        CircleComputation aCircleComputation = new CircleComputation();
	        aCircleComputation.runComputation();
	    }
	    
	    private void runComputation()
	    {
	        Scanner in = new Scanner(System.in);
	    
	        double radius;
	        System.out.println("Enter the radius: ");
	        radius = in.nextDouble();
	        
	        double area = Math.PI * Math.pow(radius, 2);//Area=PI * r^2;
	        System.out.println("The area is = "+ area);

	        double perimeter = 2*Math.PI * radius;//Perimeter = 2 *PI *r;
	        System.out.println("The perimeter is = "+ perimeter);
	    }
}
=======
package Link1;

import java.util.Scanner;

public class CircleComputation {
	 public static void main(String[] args) {
	        CircleComputation aCircleComputation = new CircleComputation();
	        aCircleComputation.runComputation();
	    }
	    
	    private void runComputation()
	    {
	        Scanner in = new Scanner(System.in);
	    
	        double radius;
	        System.out.println("Enter the radius: ");
	        radius = in.nextDouble();
	        
	        double area = Math.PI * Math.pow(radius, 2);//Area=PI * r^2;
	        System.out.println("The area is = "+ area);

	        double perimeter = 2*Math.PI * radius;//Perimeter = 2 *PI *r;
	        System.out.println("The perimeter is = "+ perimeter);
	    }
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
