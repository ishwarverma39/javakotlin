package com.livtech.demo.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * This class uses adjacency matrix for graph representation
 */
public class GraphAMatrix {
    int[][] adjMatrix;
    int vCount;
    char[] vertices;
    boolean[] visited;

    public GraphAMatrix(int vCount, char[] vertices) {
        this.vCount = vCount;
        this.vertices = vertices;
        this.adjMatrix = new int[vCount][vCount];
        visited = new boolean[vCount];
        for (int i = 0; i < vCount; i++) visited[i] = false;
    }

    public void addEdge(int s, int d) {
        if (s >= 0 && s < vCount && d >= 0 && d < vCount)
            adjMatrix[s][d] = adjMatrix[d][s] = 1;
    }

    public void removeEdge(int s, int d) {
        if (s >= 0 && s < vCount && d >= 0 && d < vCount)
            adjMatrix[s][d] = adjMatrix[d][s] = 0;
    }

    public boolean isEdge(int s, int d) {
        return s >= 0 && s < vCount && d >= 0 && d < vCount && adjMatrix[s][d] == 1;
    }

    public void displayVertex(int v) {
        System.out.print(" " + vertices[v]);
    }

    public void resetVisit() {
        for (int i = 0; i < vCount; i++) visited[i] = false;
    }

    public int getUnvisitedAdjNode(int v) {
        for (int i = 0; i < vCount; i++) {
            if (isNotVisited(v, i)) return i;
        }
        return -1;
    }

    public boolean isNotVisited(int s, int d) {
        return !visited[d] && adjMatrix[s][d] == 1;
    }

    /**
     * DFS traversing in the graph is similar to the pre-order traversing in the B-tree
     * Time complexity is O(V+E)
     */
    public void dfs() {
        System.out.println("====DFS Traverse== starts\n");
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        displayVertex(0);
        visited[0] = true;
        while (!stack.empty()) {
            int v = getUnvisitedAdjNode(stack.peek());
            if (v == -1) stack.pop();
            else {
                stack.push(v);
                displayVertex(v);
                visited[v] = true;
            }
        }
        resetVisit();
        System.out.println("\n\n====DFS Traverse== ends");
    }

    /**
     * BFS traversing is similar to the level order traversing in the tree
     * Time complexity is O(V+E)
     */
    public void bfs() {
        System.out.println("====BFS Traverse== starts\n");
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            displayVertex(v);
            for (int i = 0; i < vCount; i++) {
                if (isNotVisited(v, i)) {
                    visited[i] = true;
                    queue.add(i);
                }
            }

        }
        resetVisit();
        System.out.println("\n\n====BFS Traverse== ends");
    }

    public static void main(String[] args) {
        char[] vertices = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        GraphAMatrix graph = new GraphAMatrix(8, vertices);
        graph.addEdge(0, 1); //A -> B
        graph.addEdge(1, 2); //B -> C
        graph.addEdge(1, 7); //B -> H
        graph.addEdge(2, 3); //C -> D
        graph.addEdge(2, 4); //C -> E
        graph.addEdge(4, 5); //E -> F
        graph.addEdge(4, 6); //E -> G
        graph.addEdge(4, 7); //E -> H
        graph.dfs();
        graph.bfs();
    }

}
