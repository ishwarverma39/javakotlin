package com.livtech.demo.arrays;

public class ArrayTest {

	static int timeComplexity = 0;

	public static void main(String[] args) {
		rotation();

	}

	static void rotation() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		// oneByOne(arr, 3);
		reversalMethod(arr, 3);
		System.out.println("time complexity " + timeComplexity);
		ArrayUtils.printArray(arr);

	}

	/*
	 * Time complexity is O(n*d) and space complexity is o(1) for temporary ;
	 */
	static void oneByOneMethod(int[] arr, int d) {
		int length = arr.length;
		for (int i = 0; i < d; i++) {
			int temp = arr[0];
			for (int j = 0; j < length - 1; j++) {
				arr[j] = arr[j + 1];
				++timeComplexity;
			}
			arr[length - 1] = temp;
		}
	}

	/*
	 * Time complexity is O(n) and space complexity is O(1) for temporary ;
	 */
	static void reversalMethod(int[] arr, int d) {
		reverse(arr, 0, d - 1);
		reverse(arr, d, arr.length - 1);
		reverse(arr, 0, arr.length - 1);
	}

	static void reverse(int[] arr, int start, int end) {
		while (start < end) {
			++timeComplexity;
			int temp1 = arr[start];
			arr[start] = arr[end];
			arr[end] = temp1;
			end--;
			start++;
		}
	}

	static void blockMethod(int[] arr, int d) {

		
		
	}

	static void swap(int[] arr, int fi, int si, int d) {

	}
}
