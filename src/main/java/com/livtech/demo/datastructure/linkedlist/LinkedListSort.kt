package com.livtech.demo.datastructure.linkedlist

import com.livtech.demo.datastructure.nodes.Node

fun main() {
    val head = Node(2)
    head.next = Node(4)
    head.next.next = Node(1)
    head.next.next.next = Node(3)
    printList(head)
    val head2 = sort(head)
    printList(head2)
}

fun printList(head: Node?) {
    var cur = head
    println()
    while (cur != null) {
        print(" -> ${cur.data}")
        cur = cur.next
    }
}

fun sort(head: Node?): Node? {
    if (head == null || head.next == null) return head
    val midNode = middleNode(head)
    val midNodeNext = midNode?.next
    midNode?.next = null
    val first = sort(head)
    val second = sort(midNodeNext)
    return mergeRecursive(first, second)
}

fun middleNode(head: Node?): Node? {
    var slow = head
    var fast = head
    while (fast?.next?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }
    return slow
}

fun mergeList(first: Node?, second: Node?): Node? {
    if (first == null) return second
    if (second == null) return first
    var firstCur = first
    var secondCur = second
    val head = if (first.data <= second.data) {
        firstCur = first.next
        first
    } else {
        secondCur = second.next
        second
    }
    var cur = head
    while (firstCur != null && secondCur != null) {
        when (true) {
            firstCur.data < secondCur.data -> {
                cur.next = firstCur
                firstCur = firstCur.next
            }
            secondCur.data < firstCur.data -> {
                cur.next = secondCur
                secondCur = secondCur.next
            }
            else -> {
                cur.next = firstCur
                firstCur = firstCur.next
                cur = cur.next
                cur.next = secondCur
                secondCur = secondCur.next
            }
        }
        cur = cur.next
    }
    while (firstCur != null) {
        cur.next = firstCur
        firstCur = firstCur.next
        cur = cur.next
    }
    while (secondCur != null) {
        cur.next = secondCur
        secondCur = secondCur.next
        cur = cur.next
    }
    return head
}

fun mergeRecursive(first: Node?, second: Node?): Node? {
    if (first == null) return second
    if (second == null) return first
    val result: Node?
    if (first.data <= second.data) {
        result = first
        result.next = mergeRecursive(first.next, second)
    } else {
        result = second
        result.next = mergeRecursive(first, second.next)
    }
    return result
}