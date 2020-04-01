package com.livtech.demo.sortings;

public class QuickSortTest {
	int[] arr = { 2, 1, 9, 5, 3, 8, 4 };

	public static void main(String[] args) {

		QuickSortTest test = new QuickSortTest();
		test.runtTest();
		test.print();

	}

	void runtTest() {
		sort(arr, 0, arr.length - 1);

	}

	void print() {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " ");
		}
	}

	void sort(int[] arr, int l, int h) {
		if (l < h) {
			int pi = partition(arr, l, h);
			sort(arr, l, pi - 1);
			sort(arr, pi + 1, h);
		}
	}
	
	private int partition(int[] arr, int low, int high) {
		int pivot = arr[high]; 
       int l=low-1;
       int h=high-1;
       int k=low;
       while(k<high){
    	   if(arr[k]<=pivot)l++;
    	   if(arr[h]>pivot)h--;
    	   k++;
       }
       if(l<h)
    	   swap(arr,l,h);
       swap(arr,l+1,high);
       return l+1;
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
