package com.livtech.demo.datastructure.arrays;

public class DuplicatElement {
	public static void main(String[] args) {
		DuplicatElement duplicate=new DuplicatElement();
		duplicate.findMissingNumber();
		duplicate.findUniqueNumber();
	}
	private void findMissingNumber(){
		int[] arr={1,2,3,4,5,6,7,8,9,10,11,12,13,14,16};
		int xor1=arr[0],xor2=1;
		for(int i=1;i<arr.length;i++){
			xor1=xor1^arr[i];
		}
		for(int i=2;i<=arr.length+1;i++)
			xor2=xor2^i;
		
		System.out.println("Missing number "+String.valueOf(xor1^xor2));
		
	}
	
	private void findUniqueNumber(){
		int[] arr={1,2,3,4,5,6,1,2,4,5,6};
		int xor=0;
		for(int i=0;i<arr.length;i++){
			xor=xor^arr[i];
		}
		System.out.println("Unique number "+xor);

	}

}
