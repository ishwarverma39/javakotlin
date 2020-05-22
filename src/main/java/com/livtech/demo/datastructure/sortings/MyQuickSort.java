package com.livtech.demo.datastructure.sortings;


public class MyQuickSort {

    public void quickSortTest() {
        int[] a = {10, 80, 30, 90, 60, 40, 50, 70};
        quickSort(a, 0, a.length - 1);
        for (int value : a) System.out.print(" " + value);
    }

    private void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pivot = partition(a, low, high);
            quickSort(a, low, pivot - 1);
            quickSort(a, pivot + 1, high);
        }
    }

    private int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int left = low;
        int right = high;
        int pos = right;
        while (left < right) {
            //to get big number than pivot when iterating from left to right
            while (left < right) {
                if (a[left] > pivot) {
                    swap(a, left, right);
                    pos = left;
                    break;
                }
                left++;
            }
            // to get small number than pivot when iterating form right to left
            while (left < right) {
                if (a[right] < pivot) {
                    swap(a, left, right);
                    pos = right;
                    break;
                }
                right--;
            }
        }
        return pos;
    }

    private void swap(int[] a, int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }
}
