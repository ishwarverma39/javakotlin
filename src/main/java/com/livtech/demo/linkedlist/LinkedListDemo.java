package com.livtech.demo.linkedlist;


import com.livtech.demo.nodes.Node;

import java.util.ArrayList;

public class LinkedListDemo {

	static int timeComplexity = 0;

	public static void main(String[] args) {
		Node head = new Node();
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

	static void createListWithLoop(Node head) {
		Node node1 = new Node();
		node1.setData(2);
		head.setNext(node1);

		Node node2 = new Node();
		node2.setData(3);
		node1.setNext(node2);

		Node node3 = new Node();
		node3.setData(4);
		node2.setNext(node3);

		Node node4 = new Node();
		node4.setData(5);
		node3.setNext(node4);

		Node node5 = new Node();
		node5.setData(6);
		node4.setNext(node5);

		Node node6 = new Node();
		node6.setData(7);
		node5.setNext(node6);

		node6.setNext(node4);
	}

	static void insertNodes(Node head) {
		Node node1 = new Node();
		node1.setData(2);
		head.setNext(node1);

		Node node2 = new Node();
		node2.setData(3);
		node1.setNext(node2);

		Node node3 = new Node();
		node3.setData(4);
		node2.setNext(node3);

		Node node4 = new Node();
		node4.setData(5);
		node3.setNext(node4);

		Node node5 = new Node();
		node5.setData(6);
		node4.setNext(node5);

		Node node6 = new Node();
		node6.setData(7);
		node5.setNext(node6);

		node6.setNext(null);
	}

	static void traverseList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(" " + temp.getData());
			temp = temp.getNext();
		}
	}

	/*
	 * time complexity is O(n)
	 */
	static Node reverseOfList(Node head) {
		timeComplexity = 0;
		if (head == null) {
			return head;
		}
		Node temp = head.getNext();
		head.setNext(null);
		while (temp != null) {
			timeComplexity++;
			Node temp1 = temp.getNext();
			temp.setNext(head);
			head = temp;
			temp = temp1;
		}
		System.out.println(" time complexity of reverse the list "
				+ timeComplexity);
		return head;
	}

	static void middleNode(Node head) {
		Node slow = head, fast = head;
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

	static void nthNodeFromEnd(Node head, int n) {
		timeComplexity = 0;
		int count = 0;
		Node slow = head, fast = head;
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

	static void findLoopUsingArray(Node head) {
		timeComplexity = 0;
		ArrayList<Node> nodeList = new ArrayList<Node>();
		boolean isLoop = false;
		if (head == null)
			return;
		Node temp = head;
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

	static void findLoopUsingFastAndSlowPointer(Node head) {
		timeComplexity = 0;
		boolean isLoop = false;
		if (head == null)
			return;
		Node fast = head, slow = head;
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
