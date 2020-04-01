package com.livtech.demo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class KSliddingWindow {

	public static void main(String[] args) {
		int max = maxOfMins(Arrays.asList(new Integer[]{2,5,8,7,6,1,9,4}), 3);
		System.out.println(max);

	}
	
	public static int maxOfMins(List<Integer> a, int K){
		Deque<Integer> dq = new LinkedList<>();
		int max=Integer.MIN_VALUE;
		for(int i=0; i<K; i++){
			while(!dq.isEmpty() && a.get(dq.getLast())>=a.get(i))
				dq.removeLast();
			dq.addLast(i);
		}
		for(int i=K; i<a.size(); i++){
			if(max<a.get(dq.getFirst())) max = a.get(dq.getFirst());
			
			while(!dq.isEmpty() && a.get(i)<= a.get(dq.getLast()))
				dq.removeLast();
			while(!dq.isEmpty() && K<=i-dq.getFirst())
				dq.removeFirst();
			
			dq.addLast(i);
		}
		if(max<a.get(dq.getFirst())) max = a.get(dq.getFirst());
		return max;
	}

}
