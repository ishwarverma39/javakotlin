package com.livtech.demo.datastructure.arrays;

import java.util.HashMap;

public class CountTest {
	static HashMap<Integer, Integer> counts=new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,2,3,4,5,6,7,8,9,10,15};
		for(int i=0; i<a.length; i++){
			addCount(3, a[i]);
			addCount(5, a[i]);
		}
		print();
	}

	
	static void addCount(int num, int num2){
		int count=0;
		if(num2%num==0){
			if(counts.containsKey(num)){
				count=counts.get(num);
			}
			count++;
			counts.put(num, count);
		}
	}
	
	static void print(){
		for(Integer key:counts.keySet()){
			System.out.println("Key "+key +" "+counts.get(key));
		}
	}
}
