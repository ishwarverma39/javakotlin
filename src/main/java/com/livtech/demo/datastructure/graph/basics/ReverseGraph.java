package com.livtech.demo.datastructure.graph.basics;

import com.livtech.demo.datastructure.graph.common.GraphAList;

/**
 * Converse/Reverse/Transpose of a graph is another graph such that
 * if there is an edge from vertex u to v in Graph G1 then in Graph G2 there would be an edge from v to u
 */
public class ReverseGraph {
    static void reverse(GraphAList g1, GraphAList g2) {
        for (int i = 0; i < g1.getVCount(); i++) {
            for (int n : g1.getList()[i]) {
                g2.addEdge(n, i);
            }
        }
    }

    public static void main(String[] args) {
        char[] vertices = {'A', 'B', 'C', 'D', 'E'};
        GraphAList g1 = new GraphAList(5, vertices);
        g1.addEdge(0, 1);
        g1.addEdge(0, 3);
        g1.addEdge(0, 4);
        g1.addEdge(2, 0);
        g1.addEdge(3, 2);
        g1.addEdge(4, 3);
        g1.addEdge(4, 1);

        System.out.println("=====DFS 1=== ");
        g1.DFS(0);
        GraphAList g2 = new GraphAList(5, vertices);
        reverse(g1, g2);
        System.out.println("\n=====DFS 2=== ");
        g2.DFS(0);
    }
}
