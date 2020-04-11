package com.livtech.demo.graph.cycles;

import com.livtech.demo.graph.common.GraphAList;

import java.util.Arrays;

public class DetectCycleUnDirectedGraph {
    static boolean isCyclic(GraphAList g) {
        for (int i = 0; i < g.getVCount(); i++) {
            if (!g.isVisited(i))
                if (cyclicUtils(g, i, -1)) return true;
        }
        return false;
    }

    static boolean cyclicUtils(GraphAList g, int v, int parent) {
        g.makeVisited(v);
        for (int next : g.getList()[v]) {
            if (!g.isVisited(next)) {
                if (cyclicUtils(g, next, v)) return true;
            } else if (next != parent) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        GraphAList graph = new GraphAList(4, new char[]{'A', 'B', 'C', 'D'});
        graph.addEdge(0, 2, false);
        graph.addEdge(1, 2, false);
        graph.addEdge(1, 3, false);
        graph.addEdge(2, 3, false);
        System.out.println("There is a cycle " + isCyclic(graph));
    }
}
