package com.livtech.demo.graph.cycles;

import com.livtech.demo.graph.common.GraphAList;

import java.util.Arrays;

public class DetectCycleUsingColors {
    static final int WHITE = 0, GREY = 1, BLACK = 2;

    static boolean isCycleUtils(GraphAList g, int v, int[] processed) {
        if (processed[v] == GREY) return true;
        processed[v] = GREY;
        for (int next : g.getList()[v]) {
            return isCycleUtils(g, next, processed);
        }
        processed[v] = BLACK;
        return false;
    }

    static boolean isCyclic(GraphAList g) {
        int[] precessed = new int[g.getVCount()];
        Arrays.fill(precessed, WHITE);
        for (int i = 0; i < g.getVCount(); i++) {
            if (precessed[i] == WHITE)
                if (isCycleUtils(g, i, precessed)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        GraphAList graph = new GraphAList(4, new char[]{'A', 'B', 'C', 'D'});
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        System.out.println("There is a cycle " + isCyclic(graph));
    }
}
