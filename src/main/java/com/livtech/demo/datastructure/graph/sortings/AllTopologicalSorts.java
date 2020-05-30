package com.livtech.demo.datastructure.graph.sortings;

import com.livtech.demo.datastructure.graph.common.GraphAList;

import java.util.Stack;

public class AllTopologicalSorts {
    public static void main(String[] args) {
        char[] vertices = {'0', '1', '2', '3', '4', '5'};
        GraphAList g = new GraphAList(vertices.length, vertices);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(5, 0);
        g.addEdge(5, 2);
        new AllTopologicalSorts().allTopologicalSorts(g);
    }

    private void allTopologicalSortUtils(GraphAList g, int[] indegree, Stack<Character> stack) {
        if (stack.size() == g.getVCount()) {
            System.out.println(stack.toString());
        }
        for (int i = 0; i < g.getVCount(); i++) {
            if (!g.isVisited(i) && indegree[i] == 0) {
                g.makeVisited(i);
                stack.push(g.vertices[i]);
                for (int adj : g.getAdjacencyList(i)) {
                    indegree[adj]--;
                }
                allTopologicalSortUtils(g, indegree, stack);
                g.makeUnvisited(i);
                stack.pop();
                for (int adj : g.getAdjacencyList(i)) {
                    indegree[adj]++;
                }
            }
        }
    }

    private void allTopologicalSorts(GraphAList g) {
        int[] indegree = new int[g.getVCount()];
        for (int i = 0; i < g.getVCount(); i++) {
            for (int j : g.getAdjacencyList(i)) {
                indegree[j]++;
            }
        }
        allTopologicalSortUtils(g, indegree, new Stack<>());
    }
}
