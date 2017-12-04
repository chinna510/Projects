<<<<<<< HEAD
package Link1;

public class Fibonacci {
	int previous,next,sum,n=1;
	double average;
public void fibo(){
	int count=0;
	
	previous=next=1;

	while(n<=20){
		System.out.print(previous+"  ");
		sum=previous+next;
		previous=next;
		next=sum;
		n++;
		++count;
		average=(double)sum/count;
	}
	System.out.println("\naverage = "+average);
}
public static void main(String[] args) {
	Fibonacci fb=new Fibonacci();
	fb.fibo();
}
}
=======
package Link1;

public class Fibonacci {
	int previous,next,sum,n=1;
	double average;
public void fibo(){
	int count=0;
	
	previous=next=1;

	while(n<=20){
		System.out.print(previous+"  ");
		sum=previous+next;
		previous=next;
		next=sum;
		n++;
		++count;
		average=(double)sum/count;
	}
	System.out.println("\naverage = "+average);
}
public static void main(String[] args) {
	Fibonacci fb=new Fibonacci();
	fb.fibo();
}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
