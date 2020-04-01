package com.livtech.demo.dp;

import java.util.ArrayList;

public class MaxProfit {

	public static void main(String[] args) {
		int[] prices={100,150,120,180,90,80,200,210};
		maxProfit(prices);
		
	}
	
	static void maxProfit(int[] prices){
		int i=0;
		int n=prices.length;
		int count=0;
		while(i<n-1){
			while(i<n-1 && prices[i]>=prices[i+1])i++;
			if(i==n-1)break;
			
			Pair pair=new Pair();
			pair.buy=i;
			i++;
			
			while(i<n && prices[i-1]<=prices[i])i++;
			pair.sell=i-1;
			count++;
			System.out.println("Buy on "+(pair.buy+1) + " day and sell on "+(pair.sell+1)+" day");
		}
	}
	
	static class Pair{
		int buy;
		int sell;
	}
}
