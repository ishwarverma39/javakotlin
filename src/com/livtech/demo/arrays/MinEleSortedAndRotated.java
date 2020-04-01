package com.livtech.demo.arrays;

public class MinEleSortedAndRotated {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 10, 11, 12, 13, 16,1};
		System.out.println(min(0, a.length - 1, a));
	}

	static int min(int l, int r, int[] a) {
		int m = (l + r);
		if (r == l + 1) {
			return a[r] < a[l] ? r : l;
		} else if (a[m - 1] > a[m] && a[m] < a[m + 1])
			return m;
		else if (a[l] > a[m - 1]) {
			return min(l, m - 1, a);
		} else
			return min(m + 1, r, a);
	}

}
