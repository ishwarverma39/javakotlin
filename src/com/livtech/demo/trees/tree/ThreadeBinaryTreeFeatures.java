package com.livtech.demo.trees.tree;


import com.livtech.demo.nodes.ThreadedBTNode;

public class ThreadeBinaryTreeFeatures {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadedBTNode root = new ThreadedBTNode();
		root.setData(10);
		insertNodes(root);
		inorderTraverse(root);

	}

	static void insertNodes(ThreadedBTNode root) {

		ThreadedBTNode node1 = new ThreadedBTNode();
		node1.setData(20);

		ThreadedBTNode node2 = new ThreadedBTNode();
		node2.setData(30);

		root.setLeft(node1);
		root.setRight(node2);

		ThreadedBTNode node11 = new ThreadedBTNode();
		node11.setData(40);
		node11.setRightThreaded(true);
		node11.setRight(node1);

		ThreadedBTNode node12 = new ThreadedBTNode();
		node12.setData(50);
		node12.setRightThreaded(true);
		node12.setRight(root);

		node1.setLeft(node11);
		node1.setRight(node12);

		ThreadedBTNode node21 = new ThreadedBTNode();
		node21.setData(60);
		node21.setRightThreaded(true);
		node21.setRight(node2);

		ThreadedBTNode node22 = new ThreadedBTNode();
		node22.setData(70);

		node2.setLeft(node21);
		node2.setRight(node22);

	}

	static void inorderTraverse(ThreadedBTNode root) {
		System.out.println("======inorder traversing ");
		ThreadedBTNode node = getLeftMostNode(root);
		while (node != null) {
			System.out.println(node.getData());
			if (node.isRightThreaded()) {
				node = node.getRight();
			} else {
				node = getLeftMostNode(node.getRight());
			}
		}
	}

	static ThreadedBTNode getLeftMostNode(ThreadedBTNode node) {
		while (node != null) {
			if (node.getLeft() == null)
				return node;
			node = node.getLeft();
		}
		return node;
	}
}
