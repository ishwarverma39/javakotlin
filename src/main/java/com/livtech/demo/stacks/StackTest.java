package com.livtech.demo.stacks;

import java.util.Stack;

public class StackTest {
	Stack<Integer> stack = new Stack<>();
	int minEle;
	int maxEle;

	void push(int x) {
		if (stack.isEmpty()) {
			stack.push(x);
			minEle = x;
		} else if (x < minEle) {
			stack.push(2 * x - minEle);
			minEle = x;
		} else
			stack.push(x);
	}

	void pop() {
		if (stack.isEmpty()) {
			System.out.println("No element");
		} else {
			int x = stack.pop();
			if (x < minEle) {
				minEle = 2 * minEle - x;
			}
		}
	}
	
	void getMin(){
		if(stack.isEmpty()){
			System.out.println("Stack is empty");
		}else{
			System.out.println("Min Element" +minEle);
		}
	}
	
	public static void main(String[] args) {
		StackTest test=new StackTest();
		test.push(3);
		test.push(5);
		test.push(2);
		test.getMin();
		test.push(1);
		test.getMin();
		test.pop();
		test.getMin();
		test.pop();
		test.getMin();
	}
}
