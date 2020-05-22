package com.livtech.demo.datastructure.graph.basics;

import com.livtech.demo.datastructure.graph.common.GraphAList;

public class KCoreGraph {

    static void printKCore(int k, GraphAList graph) {
        int minDegree = Integer.MAX_VALUE;
        int sVertex = 0;
        int[] vDegree = new int[graph.getVCount()];
        for (int i = 0; i < graph.getVCount(); i++) {
            vDegree[i] = graph.getList()[i].size();
            if (minDegree > vDegree[i]) {
                minDegree = vDegree[i];
                sVertex = i;
            }
        }
        DFSUtils(graph, vDegree, sVertex, k);
        for (int i = 0; i < graph.getVCount(); i++) {
            if (!graph.isVisited(i)) {
                DFSUtils(graph, vDegree, i, k);
            }
        }
        // PRINTING K CORES
        System.out.println("K-Cores : ");
        for (int v = 0; v < graph.getVCount(); v++) {

            // Only considering those vertices which have degree
            // >= K after BFS
            if (vDegree[v] >= k) {
                System.out.printf("\n[%d]", v);

                // Traverse adjacency list of v and print only
                // those adjacent which have vDegree >= k after
                // BFS.
                for (int i : graph.getList()[v])
                    if (vDegree[i] >= k)
                        System.out.printf(" -> %d", i);
            }
        }

    }

    static boolean DFSUtils(GraphAList graph, int[] vDegree, int v, int k) {
        graph.makeVisited(v);
        for (Integer next : graph.getList()[v]) {
            if (vDegree[v] < k) vDegree[next]--;
            if (!graph.isVisited(next)) {
                if (DFSUtils(graph, vDegree, next, k))
                    vDegree[next]--;
            }
        }

        return vDegree[v] < k;
    }

    public static void main(String[] args) {
        int k = 3;
        GraphAList g1 = new GraphAList(9, new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8'});
        g1.addEdge(0, 1, false);
        g1.addEdge(0, 2, false);
        g1.addEdge(1, 2, false);
        g1.addEdge(1, 5, false);
        g1.addEdge(2, 3, false);
        g1.addEdge(2, 4, false);
        g1.addEdge(2, 5, false);
        g1.addEdge(2, 6, false);
        g1.addEdge(3, 4, false);
        g1.addEdge(3, 6, false);
        g1.addEdge(3, 7, false);
        g1.addEdge(4, 6, false);
        g1.addEdge(4, 7, false);
        g1.addEdge(5, 6, false);
        g1.addEdge(5, 8, false);
        g1.addEdge(6, 7, false);
        g1.addEdge(6, 8, false);
        printKCore(k, g1);

        System.out.println();
    }
}
