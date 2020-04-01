package com.livtech.demo.nodes;

public class SimpleNode {

	private int data;
	private SimpleNode next = null;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public SimpleNode getNext() {
		return next;
	}

	public void setNext(SimpleNode next) {
		this.next = next;
	}
}
