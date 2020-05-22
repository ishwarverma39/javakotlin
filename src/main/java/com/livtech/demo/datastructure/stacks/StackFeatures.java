package com.livtech.demo.datastructure.stacks;

public class StackFeatures {

	/**
	 * @param args
	 */
	static StackNode top = null;

	public static void main(String[] args) {

		for (int i = 1; i < 10; i++) {
			int data = i*4;
			push(data);
		}
		traverse();

		System.out.println(" \n " +	"max element " + top.getMaxElement());
		System.out.println(" min elelment " + top.getMinElement());
		
		

	}

	static void push(int data) {
		StackNode node = new StackNode();
		if (top != null) {
			node.setData(data);
			if (data > top.getMaxElement())
				node.setMaxElement(data);
			else
				node.setMaxElement(top.getMaxElement());

			if (data < top.getMinElement())
				node.setMinElement(data);
			else
				node.setMinElement(top.getMinElement());
			node.setNext(top);
			top = node;
		} else {
			top = node;
			top.setData(data);
			top.setMaxElement(data);
			top.setMinElement(data);
		}
	}

	static void pop() {
		if (top == null) {
			System.out.println("stack under flow");
		} else {
			System.out.println("poped element is " + top.getData());
			StackNode temp = top;
			top = top.getNext();
			temp = null;
		}
	}

	static void traverse() {
		StackNode temp = top;
		while (temp != null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}

	private static class StackNode {
		private int data;
		private int maxElement;
		private int minElement;
		private StackNode next = null;

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public int getMaxElement() {
			return maxElement;
		}

		public void setMaxElement(int maxElement) {
			this.maxElement = maxElement;
		}

		public int getMinElement() {
			return minElement;
		}

		public void setMinElement(int minElement) {
			this.minElement = minElement;
		}

		public StackNode getNext() {
			return next;
		}

		public void setNext(StackNode next) {
			this.next = next;
		}
	}

}
