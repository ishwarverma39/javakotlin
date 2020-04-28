package com.example;

public class ByjusTest {
    public static void main(String[] args) {
        //System.out.println("Hello");
        //printFizBuzz();
        int[] arr = {3, 2, 1};
        printArray(arr);
        sortSwapArray(arr);
        printArray(arr);
    }

    /**
     * // FizzBuzz Test
     * Write a program that prints the numbers from 1 to 100. But for multiples of three print "Fizz"
     * instead of the number and for the multiples of five print "Buzz".
     * For numbers which are multiples of both three and five print "FizzBuzz".
     * <p>
     * Sample output : 1 2 Fizz 4 Buzz ….. 14 FizzBuzz 16 ….. 98 Fizz Buzz
     */


    class Animal {
        int feets;

        public void setFeets(int feets) throws Exception {
            if (feets < 0) throw new Exception("Not accepted");
            else this.feets = feets;
        }

        public int getFeets() {
            if (feets < 0) feets = 0;
            return feets;
        }
    }

    static void printFizBuzz() {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print(" FizzBuzz ");
            } else if (i % 3 == 0) {
                System.out.print(" Fizz ");
            } else if (i % 5 == 0) {
                System.out.print(" Buzz ");
            } else
                System.out.print(" " + i);
        }
    }

    /**
     * // Single swap sorting
     * <p>
     * Sort the single swap sorted array
     * <p>
     * Input :    {21, 126, 42, 89,  36}
     * Output : {21,  36,  42, 89, 126}
     * <p>
     * Input :    {11,  44,  33, 22, 55}
     * Output : {11,  22,  33, 44, 55}
     * <p>
     * Input :    {21, 42, 36, 89,  126}
     * Output : {21,  36,  42, 89, 126}
     * <p>
     * Input :    {3, 2, 1}
     * Output : {1,  2, 3}
     */

    static void sortSwapArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            if (arr[l] > arr[r]) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                break;
            } else if (arr[l] <= arr[l + 1]) {
                l++;
            } else if (arr[r] >= arr[r - 1]) {
                r--;
            } else {
                l++;
                r--;
            }
        }
    }

    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i] + " ");
        }
        System.out.println("");
    }

    /**
     * {3, 4, 2, 3, 8, 2, 2}
     * <p>
     * {3, 4, 2, 8}
     */

}
