package com.livtech.demo.datastructure.dp;

import java.util.Arrays;

public class MaxSum2 {

    public static void main(String[] args) {
        int[] arr = {1, -2, 5, 6, -3, -9, 9};
        method1(arr);
        method2(arr);
        nCoin();
    }

    static void method1(int[] arr) {
        int maxSum = 0, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        System.out.println("Maxsum " + maxSum);
    }

    static void method2(int[] arr) {
        int maxSum = arr[0], sum = arr[0];
        for (int value : arr) {
            sum = Math.max(sum + value, value);
            maxSum = Math.max(maxSum, sum);

        }
        System.out.println("Maxsum " + maxSum);
    }

    static int[] table = new int[25];
    static int[] coins = {2, 3, 5};

    static void nCoin() {
        Arrays.fill(table, -1);
        System.out.println("Change " + makeChange(24));
    }

    static int makeChange(int n) {
        if (n < 0) return -1;
        if (n == 0) return 0;
        if (table[n] != -1) {
            return table[n];
        }
        int ans = -1;
        for (int coin : coins) {
            ans = Math.min(ans, makeChange(n - coin));
        }
        return table[n] = ans + 1;
    }
}
