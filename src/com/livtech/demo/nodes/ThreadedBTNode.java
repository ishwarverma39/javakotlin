package com.livtech.demo.nodes;

public class ThreadedBTNode {

	private int data;
	private ThreadedBTNode left = null, right = null;
	private boolean isRightThreaded = false;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public ThreadedBTNode getLeft() {
		return left;
	}

	public void setLeft(ThreadedBTNode left) {
		this.left = left;
	}

	public ThreadedBTNode getRight() {
		return right;
	}

	public void setRight(ThreadedBTNode right) {
		this.right = right;
	}

	public boolean isRightThreaded() {
		return isRightThreaded;
	}

	public void setRightThreaded(boolean isRightThreaded) {
		this.isRightThreaded = isRightThreaded;
	}
}
