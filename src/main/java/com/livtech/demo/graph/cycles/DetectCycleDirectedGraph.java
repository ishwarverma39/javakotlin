package com.livtech.demo.graph.cycles;

import com.livtech.demo.graph.common.GraphAList;

import java.util.Arrays;

public class DetectCycleDirectedGraph {
    static boolean isCyclic(GraphAList g) {
        boolean[] recStack = new boolean[g.getVCount()];
        Arrays.fill(recStack, false);
        for (int i = 0; i < g.getVCount(); i++) {
            if (cyclicUtils(g, recStack, i)) return true;
        }
        return false;
    }

    static boolean cyclicUtils(GraphAList g, boolean[] recStack, int v) {
        if (recStack[v]) return true;
        if (g.isVisited(v)) return false;
        g.makeVisited(v);
        recStack[v] = true;
        for (int next : g.getList()[v]) {
            return cyclicUtils(g, recStack, next);
        }
        recStack[v] = false;
        return false;
    }

    public static void main(String[] args) {
        GraphAList graph = new GraphAList(4, new char[]{'A', 'B', 'C', 'D'});
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        System.out.println("There is a cycle " + isCyclic(graph));
    }
}
