package com.livtech.demo.datastructure.graph.basics;

import com.livtech.demo.datastructure.graph.common.GraphAList;

import java.util.Stack;

public class CountAllPathsTwoVertex {
    /**
     * This is a recursive method to get count of all paths from vertex u to v
     * This method uses DFS and backtracking
     *
     * @param g     given DAG, this graph uses Adjacency List for representation
     * @param u     current vertex x
     * @param d     current vertex
     * @param count count of the current path
     * @return the count of the path
     */
    static int getPathsCount(GraphAList g, int u, int d, int count) {
        g.makeVisited(u);
        if (u == d) {
            count++;
        } else {
            for (int n : g.getList()[u]) {
                if (!g.isVisited(n)) {
                    count = getPathsCount(g, n, d, count);
                }
            }
        }
        g.makeUnvisited(u);
        return count;
    }

    /**
     * This is an iterative method to find the count of all paths from u to v in direct asyclic graph
     * @param g given graph
     * @param s starting vertex
     * @param d destination vertex
     * @return count of all paths
     */
    static int getPathsCount(GraphAList g, int s, int d) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        g.makeVisited(s);
        while (!stack.isEmpty()) {
            int v = stack.pop();
            g.makeUnvisited(v);
            if (v == d) {
                count++;
            }
            for (Integer n : g.getList()[v]) {
                if (!g.isVisited(n)) {
                    g.makeVisited(n);
                    stack.push(n);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        GraphAList g = new GraphAList(5, new char[]{'A', 'B', 'C', 'D', 'E'});
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 4);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(3, 2);

        int s = 0, d = 4;
        //System.out.println(" === count " + getPathsCount(g, s, d, 0));
        System.out.println(" === count " + getPathsCount(g, s, d));
    }

}
