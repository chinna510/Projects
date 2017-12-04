package com.Sortings;

public class ImprovedRadixSort {
	private static int q[], ql[];
	static {
		q = new int[256];
		ql = new int[256];
		for (int i = 0; i < q.length; q[i++] = -1)
			;
	}

	public static void radixSort(int[] arr) {
		int i, j, k, l, np[][] = new int[arr.length][2];
		for (k = 0; k < 2; k++) {
			for (i = 0; i < arr.length; np[i][0] = arr[i], np[i++][1] = -1)
				if (q[j = ((255 << (k << 3)) & arr[i]) >> (k << 3)] == -1)
					ql[j] = q[j] = i;
				else
					ql[j] = np[ql[j]][1] = i;
			for (l = q[i = j = 0]; i < q.length; q[i++] = -1)
				for (l = q[i]; l != -1; l = np[l][1])
					arr[j++] = np[l][0];
		}
	}

	public static void main(String[] args) {
		int i;
		int[] arr = new int[15];
		System.out.print("original: ");
		for (i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 1024);
			System.out.print(arr[i] + " ");
		}
		radixSort(arr);
		System.out.print("\nsorted: ");
		for (i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println("\nDone ;-)");
	}
}
