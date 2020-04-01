package com.livtech.demo.arrays;

public class SecondMin {
	public static void main(String[] args) {
		int[] a={2,4,3,5,1,7,0,6};
		secMin(a);
	}
	
	private static void secMin(int[] a){
		int min1=Integer.MAX_VALUE, min2=Integer.MAX_VALUE;
		for(int i=0;i<a.length;i++){ 
			if(a[i]<min1){
				min2=min1;
				min1=a[i];	
			}
			else if(a[i]<min2 && a[i] != min1)
				min2=a[i];
		}
		System.out.println("First min "+min1);
		System.out.println("Seccond min "+min2);

		
	}
}
