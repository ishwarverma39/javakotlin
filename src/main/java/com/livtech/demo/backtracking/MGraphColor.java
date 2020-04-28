package com.livtech.demo.backtracking;

import java.util.Arrays;

public class MGraphColor {
    static boolean canColor(int vertex, int V, int[][] graph, int[] colored, int currentColor) {
        for (int i = 0; i < V; i++) {
            if (graph[vertex][i] == 1 && colored[i] == currentColor) {
                return false;
            }
        }
        return true;
    }

    static boolean colorGraph(int[][] graph, int vertex, int V, int m, int[] colored) {
        if (vertex == V) {
            System.out.println(Arrays.toString(colored));
            return true;
        }
        for (int c = 1; c <= m; c++) {
            if (canColor(vertex, V, graph, colored, c)) {
                colored[vertex] = c;
                if (colorGraph(graph, vertex + 1, V, m, colored)) {
                    return true;
                }
                colored[vertex] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] graph = {{0, 1, 1}, {1, 0, 0}, {1, 0, 0}};
        int[] colored = {0, 0, 0};
        int m = 2;
        if (colorGraph(graph, 0, graph.length, m, colored)) {
            System.out.println("Can color adjacent vertices with diff colors");
        } else
            System.out.println("Can not color adjacent vertices with diff colors");
    }
}
