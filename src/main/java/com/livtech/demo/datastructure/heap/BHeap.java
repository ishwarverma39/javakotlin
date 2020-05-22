package com.livtech.demo.datastructure.heap;

import java.util.Arrays;

public class BHeap {
    int[] array;
    int count;
    int capacity;
    int heapType;
    public static final int MAX_HEAP = 0, MIN_HEAP = 1;

    public BHeap(int capacity, int heapType) {
        count = 0;
        this.capacity = capacity;
        this.heapType = heapType;
        this.array = new int[capacity];
    }


    public int parent(int i) {
        int parent = (i - 1) / 2;
        if (parent < 0) return -1;
        return parent;
    }

    public int leftChild(int i) {
        int left = 2 * i + 1;
        if (left >= count) return -1;
        return left;
    }

    public int rightChild(int i) {
        int right = 2 * i + 2;
        if (right >= count) return -1;
        return right;
    }

    public int getMaxElement() {
        if (count == 0) return -1;
        return array[0];
    }

    public int getMinElement() {
        if (count == 0) return -1;
        return array[0];
    }

    public int deleteMax() {
        if (count == 0) return -1;
        int data = array[0];
        array[0] = array[count - 1];
        count--;
        prelocateDown(0);
        return data;
    }

    public void prelocateDown(int i) {
        int l, r, max;
        l = leftChild(i);
        r = rightChild(i);
        max = i;
        if (l != -1 && array[i] < array[l])
            max = l;
        if (r != -1 && array[max] < array[r])
            max = r;
        if (max != i) {
            int temp = array[max];
            array[max] = array[i];
            array[i] = temp;
            prelocateDown(max);
        }
    }

    public void prelocateUp(int i) {
        int l, r, min;
        l = leftChild(i);
        r = rightChild(i);
        min = i;
        if (l != -1 && array[i] > array[l])
            min = l;
        if (r != -1 && array[min] > array[r])
            min = r;
        if (min != i) {
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
            prelocateUp(min);
        }
    }

    public int insert(int data) {
        int i;
        if (count == capacity) {
            resize();
        }
        count++;
        i = count - 1;
        while (i >= 0 && data > array[parent(i)]) {
            array[i] = array[parent(i)];
            i = (i - 1) / 2;
        }
        array[i] = data;
        return i;
    }

    private void resize() {
        int[] old = Arrays.copyOf(array, count);
        array = new int[capacity * 2];
        if (array == null) {
            System.out.println("Memory Error");
            return;
        }
        if (capacity >= 0) System.arraycopy(old, 0, array, 0, capacity);
        capacity *= 2;
    }

    public void deleteHeap() {
        count = 0;
        array = null;
        capacity = 0;
    }

    public void buildHeap(int[] arr, int n) {
        while (n > capacity) {
            resize();
        }
        if (n >= 0) System.arraycopy(arr, 0, array, 0, n);
        count = n;
        for (int i = (n - 1) / 2; i >= 0; i--) prelocateDown(i);
    }
}
