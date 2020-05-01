package com.livtech.demo.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetSum {

    static void subsetSum(int[] input, ArrayList<String> partial, int K, int i, int sum) {
        if (sum == K) {
            System.out.println(partial);
            return;
        }
        if (sum < K && i < input.length) {
            sum += input[i];
            partial.add(String.valueOf(input[i]));
            subsetSum(input, partial, K, i + 1, sum);
            sum -= input[i];
            partial.remove(String.valueOf(input[i]));
            subsetSum(input, partial, K, i + 1, sum);
        }
    }

    public static void main(String[] args) {
        int[] input = {2, 3, 1, 5, 4};
        int K = 10;
        subsetSum(input, new ArrayList<>(), K, 0, 0);
    }
}
