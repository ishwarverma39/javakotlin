package com.livtech.demo.algos;

public class MergeSortTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 1, 4, 3, 7, 5, 6, 11, 10 };
		mergeSort(a, 0, (a.length-1));
		printArray(a);

	}

	static void printArray(int[] arr) {
		int l = 0;
		while (l < arr.length) {
			System.out.print(" " + arr[l]);
			l++;
		}
	}

	static void mergeSort(int[] arr, int l, int r) {
		if (l < r) {
			int m = l + (r - l) / 2;
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);
			merge(arr, l, m, r);
		}

	}

	static void merge(int arr[], int l, int m, int r) {

		int n1 = m - l + 1, n2 = r - m;
		int a[] = new int[n1];
		int b[] = new int[n2];

		for (int i = 0; i < n1; i++) {
			a[i] = arr[l + i];
		}
		for (int j = 0; j < n2; j++) {
			try {
				b[j] = arr[m + 1 + j];
			} 
			catch (ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
			}
		}

		int i = 0, j = 0, k = l;

		while (i < n1 && j < n2) {
			if (a[i] <= b[j]) {
				arr[k] = a[i];
				i++;

			} else {
				arr[k] = b[j];
				j++;

			}
			k++;
		}

		while (i < n1) {
			arr[k] = a[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = b[j];
			j++;
			k++;
		}
	}

}
