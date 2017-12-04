<<<<<<< HEAD
package com.FirstProject;

public class PrintPatterns {

	public static void printPatternA(int size) {
		for (int i = 0; i <= size; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("# ");
			}

			System.out.println();
		}
	}

	public static void printPatternB(int size) {

		for (int i = size; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("# ");
			}
			System.out.println();
		}
	}

	public static void printPatternC(int size) {

		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				if (j >= i) {
					System.out.print("# ");

				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}

	}

	public static void printPatternD(int size) {

		for (int i = size; i >= 1; i--) {
			for (int j = 1; j <= size; j++) {
				if (j >= i) {
					System.out.print("# ");

				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}

	}

	private static void printPatternE(int size) {
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				if ((i % size <= 1) || (j % size <= 1)) {
					System.out.print("# ");
				} else {

					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

	private static void printPatternF(int size) {
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				if ((i % size <= 1) || (i == j)) {
					System.out.print("# ");
				} else {

					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

	private static void printPatternG(int size) {
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				if ((i % size <= 1) || (j + i == size + 1)) {
					System.out.print("# ");
				} else {

					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

	private static void printPatternH(int size) {
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				if ((i % size <= 1) || (i == j) || (j + i == size + 1)) {
					System.out.print("# ");
					continue;
				}
				System.out.print("  ");

			}
			System.out.println();
		}
	}

	private static void printPatternI(int size) {
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				if ((i % size <= 1) || (j % size <= 1) || (i == j)
						|| (i + j == size + 1)) {
					System.out.print("# ");
					continue;
				}
				System.out.print("  ");
			}
			System.out.println();
		}
	}
	public static void printPatternJ(int size) {

		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <=2* size-i; j++) {
				if (j >= i) {
					System.out.print("# ");
						continue;
				} 
					System.out.print("  ");
				}
			
			System.out.println();
		}

}	
	public static void printPatternK(int size) {

		for (int i = size; i >=1; i--) {
			for (int j=1; j <=2*size-i; j++) {
				if (j >= i) {
					System.out.print("# ");
						continue;
				} 
				
					System.out.print("  ");
				}
			
			System.out.println();
		}

}	
	public static void main(String[] args) {

		System.out.println("(A)" + "\n");
		PrintPatterns.printPatternA(8);
		System.out.println("(B)" + "\n");
		PrintPatterns.printPatternB(8);
		System.out.println("(C)" + "\n");
		PrintPatterns.printPatternC(8);
		System.out.println("(D)" + "\n");
		PrintPatterns.printPatternD(8);
		System.out.println("(E)" + "\n");
		PrintPatterns.printPatternE(8);
		System.out.println();
		System.out.println("(F)" + "\n");
		PrintPatterns.printPatternF(8);
		System.out.println();
		System.out.println("(G)" + "\n");
		PrintPatterns.printPatternG(8);
		System.out.println();
		System.out.println("(H)" + "\n");
		PrintPatterns.printPatternH(8);
		System.out.println();
		System.out.println("(I)" + "\n");
		PrintPatterns.printPatternI(8);
		System.out.println();
		System.out.println("(J)" + "\n");
		PrintPatterns.printPatternJ(8);
		System.out.println();
		System.out.println("(K)" + "\n");
		PrintPatterns.printPatternK(8);
		System.out.println();
	}

}
=======
package com.FirstProject;

public class PrintPatterns {

	public static void printPatternA(int size) {
		for (int i = 0; i <= size; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("# ");
			}

			System.out.println();
		}
	}

	public static void printPatternB(int size) {

		for (int i = size; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("# ");
			}
			System.out.println();
		}
	}

	public static void printPatternC(int size) {

		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				if (j >= i) {
					System.out.print("# ");

				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}

	}

	public static void printPatternD(int size) {

		for (int i = size; i >= 1; i--) {
			for (int j = 1; j <= size; j++) {
				if (j >= i) {
					System.out.print("# ");

				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}

	}

	private static void printPatternE(int size) {
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				if ((i % size <= 1) || (j % size <= 1)) {
					System.out.print("# ");
				} else {

					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

	private static void printPatternF(int size) {
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				if ((i % size <= 1) || (i == j)) {
					System.out.print("# ");
				} else {

					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

	private static void printPatternG(int size) {
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				if ((i % size <= 1) || (j + i == size + 1)) {
					System.out.print("# ");
				} else {

					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

	private static void printPatternH(int size) {
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				if ((i % size <= 1) || (i == j) || (j + i == size + 1)) {
					System.out.print("# ");
					continue;
				}
				System.out.print("  ");

			}
			System.out.println();
		}
	}

	private static void printPatternI(int size) {
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				if ((i % size <= 1) || (j % size <= 1) || (i == j)
						|| (i + j == size + 1)) {
					System.out.print("# ");
					continue;
				}
				System.out.print("  ");
			}
			System.out.println();
		}
	}
	public static void printPatternJ(int size) {

		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <=2* size-i; j++) {
				if (j >= i) {
					System.out.print("# ");
						continue;
				} 
					System.out.print("  ");
				}
			
			System.out.println();
		}

}	
	public static void printPatternK(int size) {

		for (int i = size; i >=1; i--) {
			for (int j=1; j <=2*size-i; j++) {
				if (j >= i) {
					System.out.print("# ");
						continue;
				} 
				
					System.out.print("  ");
				}
			
			System.out.println();
		}

}	
	public static void main(String[] args) {

		System.out.println("(A)" + "\n");
		PrintPatterns.printPatternA(8);
		System.out.println("(B)" + "\n");
		PrintPatterns.printPatternB(8);
		System.out.println("(C)" + "\n");
		PrintPatterns.printPatternC(8);
		System.out.println("(D)" + "\n");
		PrintPatterns.printPatternD(8);
		System.out.println("(E)" + "\n");
		PrintPatterns.printPatternE(8);
		System.out.println();
		System.out.println("(F)" + "\n");
		PrintPatterns.printPatternF(8);
		System.out.println();
		System.out.println("(G)" + "\n");
		PrintPatterns.printPatternG(8);
		System.out.println();
		System.out.println("(H)" + "\n");
		PrintPatterns.printPatternH(8);
		System.out.println();
		System.out.println("(I)" + "\n");
		PrintPatterns.printPatternI(8);
		System.out.println();
		System.out.println("(J)" + "\n");
		PrintPatterns.printPatternJ(8);
		System.out.println();
		System.out.println("(K)" + "\n");
		PrintPatterns.printPatternK(8);
		System.out.println();
	}

}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
