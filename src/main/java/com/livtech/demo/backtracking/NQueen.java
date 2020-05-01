package com.livtech.demo.backtracking;

public class NQueen {
    static boolean isSafe(int x, int y, int[][] sol, int r, int c) {
        if (x >= r || y >= c) return false;

        //column check
        for (int i = 0; i < y; i++) {
            if (sol[x][i] == 1) return false;
        }
        //upper left diagonal check
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (sol[i][j] == 1) return false;
        }

        //upper right diagonal check
        for (int i = x - 1, j = y + 1; i >= 0 && j < c; i--, j++) {
            if (sol[i][j] == 1) return false;
        }
        return true;
    }

    static boolean solveNQueen(int x, int y, int[][] sol, int q, int n, int r, int c) {
        if (q == n) {
            print(sol, r, c);
            return true;
        }
        for (int i = 0; i < r; i++) {
            if (isSafe(i, y, sol, r, c)) {
                sol[i][y] = 1;
                if (solveNQueen(i, y + 1, sol, q + 1, n, r, c)) return true;
                sol[i][y] = 0;
            }
        }
        return false;
    }

    static void print(int[][] sol, int r, int c) {
        for (int i = 0; i < r; i++) {
            System.out.println();
            for (int j = 0; j < c; j++) {
                System.out.printf("%d ", sol[i][j]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] sol = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sol[i][j] = 0;
            }
        }
        solveNQueen(0, 0, sol, 0, n, n, n);
    }
}
