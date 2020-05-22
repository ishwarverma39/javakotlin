package com.livtech.demo.datastructure.backtracking;

import java.util.ArrayList;

public class CombinationTest {
    public static void main(String[] args) {
        int[] inputs = {3, 2, 5, 8};
        combination2(inputs, 0, 2, new ArrayList<>());
    }

    static void combination(int[] inputs, int start, int k, ArrayList<Integer> output) {
        if (output.size() == k) {
            System.out.println(output.toString());
            return;
        }
        if (start == inputs.length) return;
        for (int i = start; i < inputs.length; i++) {
            output.add(inputs[i]);
            combination(inputs, i + 1, k, output);
            output.remove(output.size() - 1);
        }
    }

    static void combination2(int[] inputs, int start, int k, ArrayList<Integer> output) {
        if (output.size() == k) {
            System.out.println(output.toString());
            return;
        }
        if (start == inputs.length) return;
        output.add(inputs[start]);
        combination2(inputs, start + 1, k, output);
        output.remove(output.size() - 1);
        combination2(inputs, start+1, k, output);

    }
}
