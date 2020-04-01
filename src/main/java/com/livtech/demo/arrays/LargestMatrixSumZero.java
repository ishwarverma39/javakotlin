package com.livtech.demo.arrays;

import java.util.HashMap;
import java.util.Scanner;

public class LargestMatrixSumZero {

	static int r, c;
	static int[][] arr;
	static final int MAX = 100;

	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		r = s.nextInt();
		c = s.nextInt();
		arr = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				arr[i][j] = s.nextInt();
			}
		}
		sumZeroMatrix(arr,r,c);
	}

	static boolean sumZero(int temp[], int starti, int endj, int n) {
		HashMap<Integer, Integer> presum = new HashMap<>();
		int sum = 0;
		int max_length = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			sum += temp[i];

			if (temp[i] == 0 && max_length == 0) {
				starti = i;
				endj = i;
				max_length = 1;
			}
			if (sum == 0) {
				if (max_length < i + 1) {
					starti = 0;
					endj = i;
				}
				max_length = i + 1;
			}
			if (presum.containsKey(sum)) {
				int old = max_length;
				max_length = Math.max(max_length, i - presum.get(sum));

				if (old < max_length) {
					endj = i;
					starti = presum.get(sum) + 1;
				}
			} else
				presum.put(sum, i);
		}
		return (max_length != 0);
	}

	static void sumZeroMatrix(int a[][], int row, int col) {
		int temp[] = new int[row];
		// Variables to store the final output
		int fup = 0, fdown = 0, fleft = 0, fright = 0;
		int up = 0, down = 0;
		int maxl = Integer.MIN_VALUE;

		for (int left = 0; left < col; left++) {
			for (int right = left; right < col; right++) {

				for (int i = 0; i < row; i++)
					temp[i] += a[i][right];

				boolean isZero = sumZero(temp, up, down, row);
				int ele = (down - up + 1) * (right - left + 1);
				if (isZero && ele > maxl) {
					fup = up;
					fdown = down;
					fleft = left;
					fright = right;
					maxl = ele;
				}
			}
		}

		if (fup == 0 && fdown == 0 && fleft == 0 && fright == 0 && a[0][0] != 0) {
			System.out.println("No zero-sum sub-matrix exists");
			return;
		}

		// Print final values
		for (int j = fup; j <= fdown; j++) {
			for (int i = fleft; i <= fright; i++)
				System.out.print(" " + a[i][j]);
			System.out.println("");
		}
	}

}
