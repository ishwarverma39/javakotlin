package com.livtech.demo.datastructure.graph.sortings;

import com.livtech.demo.datastructure.graph.common.GraphAList;

import java.util.Stack;

public class TopologicalSorting {

    public static void main(String[] args) {
        char[] vertices = {'0','1','2', '3','4','5'};
        GraphAList g = new GraphAList(vertices.length, vertices);
        g.addEdge(2,3);
        g.addEdge(3, 1);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(5, 0);
        g.addEdge(5, 2);
        TopologicalSorting sorting = new TopologicalSorting();
        sorting.topologicalSort(g);
    }

    void topologicalSort(GraphAList g) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < g.getVCount(); i++) {
            if (!g.isVisited(i)) {
                sortUtils(g, i, stack);
            }
        }
        System.out.println(stack.toString());
    }

    void sortUtils(GraphAList g, int v, Stack<Character> stack) {
        g.makeVisited(v);
        for (int i : g.getAdjacencyList(v)) {
            if (!g.isVisited(i)) {
                sortUtils(g, i, stack);
            }
        }
        stack.push(g.vertices[v]);
    }
}
