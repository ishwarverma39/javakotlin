package com.livtech.demo.arrays;

public class SecondMin {
	public static void main(String[] args) {
		int[] a={2,4,3,5,7,6};
		secMin(a);
	}
	
	private static void secMin(int[] a){
		int min1=Integer.MAX_VALUE, min2=Integer.MAX_VALUE;
		for (int value : a) {
			if (value < min1) {
				min2 = min1;
				min1 = value;
			} else if (value < min2 && value != min1)
				min2 = value;
		}
		System.out.println("First min "+min1);
		System.out.println("Seccond min "+min2);

		
	}
}
