package com.livtech.demo.algos;

import java.util.HashMap;

public class PairsWithSameSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		HashMap<Integer, Pair> sumMap = new HashMap<Integer, Pair>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int sum = arr[i] + arr[j];
				if (sumMap.containsKey(sum)) {
					Pair pair = sumMap.get(sum);
					System.out.println(" sum = " + sum + " first pair("
							+ pair.getFirst() + ", " + pair.getSecond() + ")"
							+ " second pair(" + arr[i] + ", " + arr[j] + ")");
				} else {
					Pair pair = new Pair(arr[i], arr[j]);
					sumMap.put(sum, pair);
				}
			}
		}
	}

	private static class Pair {
		private int first;
		private int second;

		public Pair(int first, int second) {
			this.setFirst(first);
			this.setSecond(second);
		}

		public int getSecond() {
			return second;
		}

		public void setSecond(int second) {
			this.second = second;
		}

		public int getFirst() {
			return first;
		}

		public void setFirst(int first) {
			this.first = first;
		}
	}
}
