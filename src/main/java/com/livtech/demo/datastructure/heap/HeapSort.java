package com.livtech.demo.datastructure.heap;

import java.util.Arrays;

public class HeapSort {
    static void sort(int[] arr) {
        int n = arr.length;
        BHeap heap = new BHeap(n, BHeap.MAX_HEAP);
        heap.buildHeap(arr, n);
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = heap.deleteMax();
        }
        System.out.println("Sorted Array -> " + Arrays.toString(arr));
        heap.deleteHeap();
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 5, 3};
        sort(arr);
    }
}
