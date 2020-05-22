package com.livtech.demo.datastructure.graph.basics;

import com.livtech.demo.datastructure.graph.common.GraphAList;

/**
 * There is a tree if a vertex is not visited anytime from any where then the vertex is root of the tree
 * This we can achieve by DFS
 */
public class TreeCountInGraph {
    static void DFS(GraphAList g, int v) {
        g.makeVisited(v);
        for (int n : g.getList()[v]) {
            if (!g.isVisited(n)) {
                DFS(g, n);
            }
        }
    }

    static int getTreeCount(GraphAList g) {
        int count = 0;
        for (int i = 0; i < g.getVCount(); i++) {
            if (!g.isVisited(i)) {
                DFS(g, i);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        GraphAList g = new GraphAList(5, new char[]{'0', '1', '2', '3', '4'});
        g.addEdge(0, 1, false);
        g.addEdge(0, 2, false);
        g.addEdge(3, 4, false);

        System.out.println(" count of trees " + getTreeCount(g));
    }
}
