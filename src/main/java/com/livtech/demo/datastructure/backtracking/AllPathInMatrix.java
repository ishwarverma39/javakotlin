package com.livtech.demo.datastructure.backtracking;

import java.util.ArrayList;
import java.util.List;

public class AllPathInMatrix {

    static boolean pathUtils(int[][] a, int r, int c, int i, int j, List<String> path) {
        if (i == r - 1 && j == c - 1) {
            path.add(String.valueOf(a[i][j]));
            System.out.println(path.toString());
            path.remove(String.valueOf(a[i][j]));
            return false;
        }
        if (i < r && j < c) {
            path.add(String.valueOf(a[i][j]));
            if (pathUtils(a, r, c, i + 1, j, path)) return true;
            if (pathUtils(a, r, c, i, j + 1, path)) return true;
            path.remove(String.valueOf(a[i][j]));
        }
        return false;
    }

    static void allPath(int[][] a) {
        pathUtils(a, a.length, a[0].length, 0, 0, new ArrayList<>());
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}};
        allPath(a);
    }
}
