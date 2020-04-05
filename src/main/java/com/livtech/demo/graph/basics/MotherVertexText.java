package com.livtech.demo.graph.basics;

import com.livtech.demo.graph.common.GraphAList;

/**
 * Mother vertex is such a vertex in the directed graph that all other vertices can by reached by a path from that
 * vertex
 */
public class MotherVertexText {
    static int getMotherVertex(GraphAList g) {
        int v = 0;
        for (int i = 0; i < g.getVCount(); i++) {
            if (!g.isVisited(i)) {
                g.DFS(i);
                v = i;
            }
        }
        g.makeUnvisited();
        System.out.println("\n======");
        g.DFS(v);
        for (int i = 0; i < g.getVCount(); i++) {
            if (!g.isVisited(i)) return -1;
        }
        return v;

    }

    public static void main(String[] args) {
        GraphAList g = new GraphAList(7, new char[]{'0', '1', '2', '3', '4', '5', '6'});
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(4, 1);
        g.addEdge(6, 4);
        g.addEdge(5, 6);
        g.addEdge(5, 2);
        g.addEdge(6, 0);
        System.out.println("\nMother Vertex = " + getMotherVertex(g));
    }
}
