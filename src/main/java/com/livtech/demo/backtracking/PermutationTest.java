package com.livtech.demo.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationTest {
    public static void main(String[] args) {
        int[] inputs = {1, 2, 3};
        boolean[] used = new boolean[inputs.length];
        Arrays.fill(used, false);
        permutation(inputs, used, new ArrayList<>());
    }

    static void permutation(int[] inputs, boolean[] used, ArrayList<Integer> partial) {
        if (partial.size() == inputs.length) {
            System.out.println(partial.toString());
        } else {
            for (int i = 0; i < inputs.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    partial.add(inputs[i]);
                    permutation(inputs, used, partial);
                    partial.remove(partial.size() - 1);
                    used[i] = false;
                }
            }
        }
    }

    static void iterativeMethod(int[] inputs){
        for (int i=0; i< inputs.length; i++){
            ArrayList<Integer> output = new ArrayList<>();
        }
    }

}
