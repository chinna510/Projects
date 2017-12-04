<<<<<<< HEAD
package com.FirstProject;

public class MatrixMul {
	static int a[][] = new int[][] { { 1, 2, 3 }, { 3, 4, 5 } };
	static int b[][] = new int[][] { { 0, 1 }, { 2, 3 }, { 3, 5 } };

	public void printIntMatrix(int[][] m) {
		for (int[] first : m) {
			for (int aInt : first) {
				System.out.print("   " + aInt);
			}
			System.out.println();
		}
	}

	public boolean haveSameDimension(int[][] m1, int[][] m2) {
		if (m1.length != m2.length) {
			return false;
		}
		for (int i = 0; i < m1.length; i++) {
			if (m1[i].length == m2[i].length) {
				continue;
			}
			return false;
		}
		return true;
	}

	public int[][] add(int[][] m1, int[][] m2) {
		int[][] result = new int[m1.length][];
		for (int i = 0; i < result.length; i++) {
			result[i] = m1[i].clone();
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] += m2[i][j];
			}
		}

		return result;

	}

	public boolean haveAllowedDimension(int[][] m1, int[][] m2) {
		// check first matrix deminsion
		int maxLengthM1 = 0;
		for (int[] a : m1) {
			maxLengthM1 = (maxLengthM1 <= a.length) ? a.length : maxLengthM1;
		}
		for (int[] a : m1) {
			if (maxLengthM1 == a.length) {
				continue;
			}
			return false;
		}

		// check first matrix deminsion
		int maxLengthM2 = 0;
		for (int[] b : m2) {
			maxLengthM2 = (maxLengthM2 <= b.length) ? b.length : maxLengthM2;
		}
		for (int[] b : m2) {
			if (maxLengthM2 == b.length) {
				continue;
			}
			return false;
		}

		// check dimenion
		return m1[0].length == m2.length;
	}

	public int[][] multiply(int[][] m1, int[][] m2) {
		int[][] c = new int[m1.length][m2[0].length];
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				c[i][j] = 0;
				for (int k = 0; k < m1[0].length; k++) {
					c[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return c;
	}

	public static void main(String[] args) {
		MatrixMul mul = new MatrixMul();
		mul.printIntMatrix(a);
		if (mul.haveSameDimension(a, a)) {
			System.out.println("Add matrix A to A:");
			mul.printIntMatrix(mul.add(a, a));

		}
		System.out.println();
		if (mul.haveAllowedDimension(a, b)) {
			System.out.println(" multiply mtrix A to b:");
			mul.printIntMatrix(mul.multiply(a, b));

		}

	}
=======
package com.FirstProject;

public class MatrixMul {
	static int a[][] = new int[][] { { 1, 2, 3 }, { 3, 4, 5 } };
	static int b[][] = new int[][] { { 0, 1 }, { 2, 3 }, { 3, 5 } };

	public void printIntMatrix(int[][] m) {
		for (int[] first : m) {
			for (int aInt : first) {
				System.out.print("   " + aInt);
			}
			System.out.println();
		}
	}

	public boolean haveSameDimension(int[][] m1, int[][] m2) {
		if (m1.length != m2.length) {
			return false;
		}
		for (int i = 0; i < m1.length; i++) {
			if (m1[i].length == m2[i].length) {
				continue;
			}
			return false;
		}
		return true;
	}

	public int[][] add(int[][] m1, int[][] m2) {
		int[][] result = new int[m1.length][];
		for (int i = 0; i < result.length; i++) {
			result[i] = m1[i].clone();
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] += m2[i][j];
			}
		}

		return result;

	}

	public boolean haveAllowedDimension(int[][] m1, int[][] m2) {
		// check first matrix deminsion
		int maxLengthM1 = 0;
		for (int[] a : m1) {
			maxLengthM1 = (maxLengthM1 <= a.length) ? a.length : maxLengthM1;
		}
		for (int[] a : m1) {
			if (maxLengthM1 == a.length) {
				continue;
			}
			return false;
		}

		// check first matrix deminsion
		int maxLengthM2 = 0;
		for (int[] b : m2) {
			maxLengthM2 = (maxLengthM2 <= b.length) ? b.length : maxLengthM2;
		}
		for (int[] b : m2) {
			if (maxLengthM2 == b.length) {
				continue;
			}
			return false;
		}

		// check dimenion
		return m1[0].length == m2.length;
	}

	public int[][] multiply(int[][] m1, int[][] m2) {
		int[][] c = new int[m1.length][m2[0].length];
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				c[i][j] = 0;
				for (int k = 0; k < m1[0].length; k++) {
					c[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return c;
	}

	public static void main(String[] args) {
		MatrixMul mul = new MatrixMul();
		mul.printIntMatrix(a);
		if (mul.haveSameDimension(a, a)) {
			System.out.println("Add matrix A to A:");
			mul.printIntMatrix(mul.add(a, a));

		}
		System.out.println();
		if (mul.haveAllowedDimension(a, b)) {
			System.out.println(" multiply mtrix A to b:");
			mul.printIntMatrix(mul.multiply(a, b));

		}

	}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
}