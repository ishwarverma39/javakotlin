package com.livtech.demo.datastructure.dp;

public class MaxSum {

	public static void main(String[] args) {
		int[] arr ={1,-2,5,6,-3,-9,9};
		method1(arr);
		method2(arr);
	}
	static void method1(int[] arr){
		int maxSum=0,sum=0;
		for(int i=0; i<arr.length;i++){
			sum=0;
			for(int j=i;j<arr.length;j++){
				sum+=arr[j];
				if(sum>maxSum){
					maxSum=sum;
				}
			}
		}
		System.out.println("Maxsum "+maxSum);
	}
	static void method2(int[] arr){
		int maxSum=arr[0],sum=arr[0];
		for (int value : arr) {
			sum = Math.max(sum + value, value);
			maxSum = Math.max(maxSum, sum);

		}
		System.out.println("Maxsum "+maxSum);
	}
}
