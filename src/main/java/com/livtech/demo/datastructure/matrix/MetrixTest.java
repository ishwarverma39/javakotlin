package com.livtech.demo.datastructure.matrix;

public class MetrixTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		makeZeroOfRowAndColumns();
	}

	static void makeZeroOfRowAndColumns() {

		int[][] a = { { 1, 0, 1 }, { 1, 1, 1 }, { 1, 0, 1 } };
		int[][] b = new int[3][3];
		int r = 3, c = 3;
		for (int i = 0; i < r; i++) {
			System.out.println("");
			for (int j = 0; j < c; j++) {
				int sum = 0;
				for (int k = 0; k < r; k++) {
					sum += a[i][k] * a[k][j];
				}
				if (sum == r)
					b[i][j] = 1;
				else
					b[i][j] = 0;
					System.out.print(" " + b[i][j]);
			}
		}
	}

}
