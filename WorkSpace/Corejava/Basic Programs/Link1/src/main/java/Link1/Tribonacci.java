<<<<<<< HEAD
package Link1;

public class Tribonacci {
	int first=0 , middle=1, last=2, sum, i, n = 20,count=0;
	double average;

	public void tribo() {

		System.out.print(first + " " + middle + " " + last);
		for (i = 4; i <= n; i++) {
			sum = first + middle + last;
			System.out.print(" "+ sum);
			first = middle;
			middle = last;
			last = sum;
			++count;
			average=(double)sum/(count);
			
		}
		System.out.println("\naverage = "+average);
		System.out.println(count);
	}

	public static void main(String[] args) {
		Tribonacci tri = new Tribonacci();
		tri.tribo();
	}
}
=======
package Link1;

public class Tribonacci {
	int first=0 , middle=1, last=2, sum, i, n = 20,count=0;
	double average;

	public void tribo() {

		System.out.print(first + " " + middle + " " + last);
		for (i = 4; i <= n; i++) {
			sum = first + middle + last;
			System.out.print(" "+ sum);
			first = middle;
			middle = last;
			last = sum;
			++count;
			average=(double)sum/(count);
			
		}
		System.out.println("\naverage = "+average);
		System.out.println(count);
	}

	public static void main(String[] args) {
		Tribonacci tri = new Tribonacci();
		tri.tribo();
	}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
