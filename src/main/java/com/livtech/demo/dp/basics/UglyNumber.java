package com.livtech.demo.dp.basics;

public class UglyNumber {
    /**
     * Ugly numbers are numbers whose only prime factors are 2, 3 or 5.
     * The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
     * shows the first 11 ugly numbers. By convention, 1 is included.
     */
    static int maxDivision(int a, int b) {
        while (a % b == 0)
            a = a / b;
        return a;
    }

    static boolean isUglyNumber(int n) {
        n = maxDivision(n, 2);
        n = maxDivision(n, 3);
        n = maxDivision(n, 5);
        return n == 1;
    }

    static int getUglyNumber(int n) {
        int i = 1;
        int count = 0;
        while (count < n) {
            if (isUglyNumber(i)) {
                count++;
            }
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.printf(" %dth ugly Number = %d ", n, getUglyNumber(n));
    }
}
