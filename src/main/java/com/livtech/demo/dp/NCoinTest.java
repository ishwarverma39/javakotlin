package com.livtech.demo.dp;

import java.util.Scanner;

public class NCoinTest {
    static int getChange(int sum, int[] coins, int coinPos) {
        if (sum == 0) {
            return 1;
        }
        if (sum < 0 || coinPos <= 0) return 0;
        System.out.print(" " + coins[coinPos-1]);
        return getChange(sum, coins, coinPos - 1) + getChange(sum - coins[coinPos - 1], coins, coinPos);
    }

    public static void main(String[] args) {
        System.out.println(" count " + getChange(4, new int[]{1, 2, 3}, 3));
    }
}
