package com.livtech.demo.datastructure.sortings;

public class MergsSortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 9,4,6,2,8,3,1,5,7 };

		System.out.println("Given Array");
		printArray(arr);

		MergsSortTest ob = new MergsSortTest();
		ob.sort(arr, 0, arr.length - 1);

		System.out.println("\nSorted array");
		printArray(arr);
	}

	void sort(int[] arr, int l, int r) {
		if (r > l) {
			int m = (l + r) / 2;
			sort(arr, l, m);

			sort(arr, m + 1, r);

			merge(arr, l, m, r);
		}
	}

	void merge(int[] arr, int l, int m, int r) {
		int s1 = m - l + 1;
		int s2 = r - m;
		int[] a = new int[s1];
		int[] b = new int[s2];

		for (int i = 0; i < s1; i++)
			a[i] = arr[l + i];

		for (int i = 0; i < s2; i++)
			b[i] = arr[m + 1+i];

		int i = 0, j = 0, k = l;
		while (i < s1 || j < s2) {
			if (i < s1 && j < s2 && a[i] <= b[j]) {
				arr[k] = a[i];
				i++;
			} else if (i < s1 && j < s2 && a[i] > b[j]) {
				arr[k] = b[j];
				j++;
			} else if (i < s1) {
				arr[k] = a[i];
				i++;
			} else {
				arr[k] = b[j];
				j++;
			}
			k++;
		}
	}

	static void printArray(int[] arr) {
		for (int value : arr) System.out.print(value + " ");
		System.out.println();
	}

}
