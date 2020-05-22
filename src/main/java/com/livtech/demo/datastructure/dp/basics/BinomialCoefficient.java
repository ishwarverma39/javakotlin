package com.livtech.demo.datastructure.dp.basics;

import static java.lang.Math.min;

/**
 * BinomialCoefficient is also know as Combination
 */
public class BinomialCoefficient {
    /**
     * This is a recursive solution to get number of ways to pick k items from n items
     * Time complexity is exponential for this
     *
     * @param n number of the total objects at point of time
     * @param k number of the picked objects at current time
     * @return return the number of ways to pick k items form n items
     */
    static int getBC(int n, int k) {
        if (k == 0 || k == n) return 1;
        return getBC(n - 1, k - 1) + getBC(n - 1, k);
    }

    /**
     * This is a dynamic programing solution for the above one
     * Time complexity is O(n*K)
     * Space complexity is O(K)
     *
     * @param n number of the total objects at point of time
     * @param k number of the picked objects at current time
     * @return return the number of ways to pick k items form n items
     */
    static int binomialCoeffDP(int n, int k) {
        int[] C = new int[k + 1];

        // nC0 is 1
        C[0] = 1;

        for (int i = 1; i <= n; i++) {
            // Compute next row of pascal
            // triangle using the previous row
            for (int j = min(i, k); j > 0; j--)
                C[j] = C[j] + C[j - 1];
        }
        return C[k];
    }

    static int binomialCoeffDP2(int n, int k)
    {
        int[][] C = new int[n+1][k+1];
        int i, j;

        // Calculate  value of Binomial Coefficient in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (j = 0; j <= min(i, k); j++)
            {
                // Base Cases
                if (j == 0 || j == i)
                    C[i][j] = 1;

                    // Calculate value using previously stored values
                else
                    C[i][j] = C[i-1][j-1] + C[i-1][j];
            }
        }

        return C[n][k];
    }
    public static void main(String[] args) {
        int n = 5, k = 2;
        //System.out.printf("Combination of %d from %d  is %d ", k, n, getBC(n, k));
        System.out.printf("Selection of %d items from %d items is %d ", k, n, binomialCoeffDP2(n, k));
    }

}
