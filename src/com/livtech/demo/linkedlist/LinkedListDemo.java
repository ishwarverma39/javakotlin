package com.livtech.demo.linkedlist;


import com.livtech.demo.nodes.SimpleNode;

import java.util.ArrayList;

public class LinkedListDemo {

	static int timeComplexity = 0;

	public static void main(String[] args) {
		SimpleNode head = new SimpleNode();
		head.setData(1);
		 insertNodes(head); System.out.println("\n Nodes in list ");
		  traverseList(head);
		 /* 
		 * System.out.println("\n Reverse of list "); head =
		 * reverseOfList(head); traverseList(head);
		 */
		middleNode(head); nthNodeFromEnd(head, 2);
		 
		//createListWithLoop(head);
		// findLoopUsingArray(head);
		//findLoopUsingFastAndSlowPointer(head);
	}

	static void createListWithLoop(SimpleNode head) {
		SimpleNode node1 = new SimpleNode();
		node1.setData(2);
		head.setNext(node1);

		SimpleNode node2 = new SimpleNode();
		node2.setData(3);
		node1.setNext(node2);

		SimpleNode node3 = new SimpleNode();
		node3.setData(4);
		node2.setNext(node3);

		SimpleNode node4 = new SimpleNode();
		node4.setData(5);
		node3.setNext(node4);

		SimpleNode node5 = new SimpleNode();
		node5.setData(6);
		node4.setNext(node5);

		SimpleNode node6 = new SimpleNode();
		node6.setData(7);
		node5.setNext(node6);

		node6.setNext(node4);
	}

	static void insertNodes(SimpleNode head) {
		SimpleNode node1 = new SimpleNode();
		node1.setData(2);
		head.setNext(node1);

		SimpleNode node2 = new SimpleNode();
		node2.setData(3);
		node1.setNext(node2);

		SimpleNode node3 = new SimpleNode();
		node3.setData(4);
		node2.setNext(node3);

		SimpleNode node4 = new SimpleNode();
		node4.setData(5);
		node3.setNext(node4);

		SimpleNode node5 = new SimpleNode();
		node5.setData(6);
		node4.setNext(node5);

		SimpleNode node6 = new SimpleNode();
		node6.setData(7);
		node5.setNext(node6);

		node6.setNext(null);
	}

	static void traverseList(SimpleNode head) {
		SimpleNode temp = head;
		while (temp != null) {
			System.out.print(" " + temp.getData());
			temp = temp.getNext();
		}
	}

	/*
	 * time complexity is O(n)
	 */
	static SimpleNode reverseOfList(SimpleNode head) {
		timeComplexity = 0;
		if (head == null) {
			return head;
		}
		SimpleNode temp = head.getNext();
		head.setNext(null);
		while (temp != null) {
			timeComplexity++;
			SimpleNode temp1 = temp.getNext();
			temp.setNext(head);
			head = temp;
			temp = temp1;
		}
		System.out.println(" time complexity of reverse the list "
				+ timeComplexity);
		return head;
	}

	static void middleNode(SimpleNode head) {
		SimpleNode slow = head, fast = head;
		timeComplexity = 0;
		while (fast != null) {
			timeComplexity++;
			fast = fast.getNext();

			if (fast == null) {
				break;
			}
			fast = fast.getNext();
			slow = slow.getNext();
		}
		System.out.println("\n middle node is " + slow.getData());
		System.out.println(" time complexity of to find middle node "
				+ timeComplexity);

	}

	static void nthNodeFromEnd(SimpleNode head, int n) {
		timeComplexity = 0;
		int count = 0;
		SimpleNode slow = head, fast = head;
		while (fast != null) {
			timeComplexity++;
			count++;
			if (count - n > 0) {
				slow = slow.getNext();
			}
			fast = fast.getNext();

		}
		System.out.println("\n " + n + "th node for last is " + slow.getData());
		System.out.println(" time complexity of to find nth node from end "
				+ timeComplexity);
	}

	static void findLoopUsingArray(SimpleNode head) {
		timeComplexity = 0;
		ArrayList<SimpleNode> nodeList = new ArrayList<SimpleNode>();
		boolean isLoop = false;
		if (head == null)
			return;
		SimpleNode temp = head;
		while (temp != null) {
			timeComplexity++;
			if (nodeList.contains(temp)) {
				isLoop = true;
				break;
			} else {
				nodeList.add(temp);
			}
			temp = temp.getNext();
		}

		if (isLoop) {
			System.out.println("Loop is present at " + temp.getData());
		}

		else
			System.out.println("Loop is not present");

		System.out.println("time complexity to find loop using hashmap "
				+ timeComplexity);
	}

	static void findLoopUsingFastAndSlowPointer(SimpleNode head) {
		timeComplexity = 0;
		boolean isLoop = false;
		if (head == null)
			return;
		SimpleNode fast = head, slow = head;
		while (slow != null && fast != null && fast.getNext() != null) {
			timeComplexity++;
			fast = fast.getNext().getNext();
			slow = slow.getNext();
			/*
			 * if (fast == null) { isLoop = false; break; }
			 */
			if (fast == slow) {
				isLoop = true;
				break;
			}
			/*fast = fast.getNext();
			slow = slow.getNext();*/

		}

		if (isLoop) {
			System.out.println("Loop is present at " + fast.getData());
		}

		else
			System.out.println("Loop is not present");

		System.out.println("time complexity to find loop using two pointers "
				+ timeComplexity);
	}

}
