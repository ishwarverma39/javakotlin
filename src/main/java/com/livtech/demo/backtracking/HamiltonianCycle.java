package com.livtech.demo.backtracking;

import java.util.Arrays;

public class HamiltonianCycle {

    static boolean hamCycleUtil(int[][] graph, int V, int v, int[] path, int index, boolean[] visited) {
        if (index == V) {
            System.out.println(Arrays.toString(path));
            return true;
        }
        if (!visited[v]) {
            path[index] = v;
            visited[v] = true;
            if (index == V - 1 && graph[v][0] == 1) {
                path[index + 1] = 0;
                hamCycleUtil(graph, V, v, path, index + 1, visited);
                return true;
            }
            for (int i = 0; i < V; i++) {
                if (!visited[i] && graph[v][i] == 1) {
                    if (hamCycleUtil(graph, V, i, path, index + 1, visited)) return true;
                }
            }
            path[index] = -1;
            visited[v] = false;
        }

        return false;
    }

    static void hamCycle(int[][] graph, int V) {
        int[] path = new int[V + 1];
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        Arrays.fill(path, -1);
        hamCycleUtil(graph, V, 0, path, 0, visited);
    }

    public static void main(String[] args) {
        /* Let us create the following graph
           (0)--(1)--(2)
            |   / \   |
            |  /   \  |
            | /     \ |
           (3)-------(4)    */
        int[][] graph1 = {{0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0},
        };

        hamCycle(graph1, 5);
        /* Let us create the following graph
           (0)--(1)--(2)
            |   / \   |
            |  /   \  |
            | /     \ |
           (3)       (4)    */
        int[][] graph2 = {{0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
        };
        hamCycle(graph2, 5);
    }
}
