package com.livtech.demo.dp;

public class DPTest {

	private int[] values;

	public static void main(String[] args) {
		DPTest test = new DPTest();
		test.memoizationTest();
		test.tabulizationTest();
	}

	private void memoizationTest() {
		values = new int[100];
		for (int i = 0; i < 100; i++)
			values[i] = -1;
		System.out.println("memoisation test value of fin(10) " + fib(10));
	}

	private int fib(int n) {
		if (values[n] == -1) {
			if (n <= 1)
				values[n] = n;
			else
				values[n] = fib(n - 1) + fib(n - 2);
		}
		return values[n];

	}
	
	private void tabulizationTest(){
		values[0]=0;values[1]=1;
		int n=5;
		for(int i=2;i<=n;i++){
			values[i]=values[i-1]+values[i-2];
		}
		System.out.println("tabulizationTest  value of fin(10) " + fib(10));

	}

}
