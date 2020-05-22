package com.livtech.demo.datastructure.matrix;


public class MatrixSearch {
    public void searchInMatrix() {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int K = 5;
        int i = a.length - 1;
        int j = 0;
        while (j <= i) {
            if (a[i][j] == K) {
                System.out.print(" i , j " + i + j);
                break;
            }else if(a[i][j] > K){
                i--;
            }else if(a[i][j] < K){
                j++;
            }
        }
    }
}
