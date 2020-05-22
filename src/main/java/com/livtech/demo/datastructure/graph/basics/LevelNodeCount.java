package com.livtech.demo.datastructure.graph.basics;

import com.livtech.demo.datastructure.graph.common.GraphAList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LevelNodeCount {
    static int countNodesAtLevel(GraphAList g, int level) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        g.makeVisited(0);
        queue.add(-1);
        int count = 0;
        int l = 0;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            while (v != -1) {
                count++;
                for (Integer i : g.getList()[v]) {
                    if (!g.isVisited(i)) {
                        queue.add(i);
                        g.makeVisited(i);
                    }
                }
                v = queue.remove();
                if (v == -1) {
                    if (l == level) return count;
                    queue.add(-1);
                    count = 0;
                    l++;
                }
            }
        }
        return -1;
    }

    static int BFS(GraphAList graph, int l) {
        int count = 0;
        int[] level = new int[graph.getVCount()];
        Arrays.fill(level, 0);
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        graph.makeVisited(0);

        while (q.size() != 0) {
            int s = q.remove();
            for (Integer n : graph.getList()[s]) {
                if (!graph.isVisited(n)) {
                    graph.makeVisited(n);
                    q.add(n);
                    level[n] = level[s] + 1;
                    if (level[n] == l)
                        count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        GraphAList g = new GraphAList(6, new char[]{'0', '1', '2', '3', '4', '5'});
        g.addEdge(0, 1, false);
        g.addEdge(0, 2, false);
        g.addEdge(1, 3, false);
        g.addEdge(2, 4, false);
        g.addEdge(2, 5, false);

        int level = 1;
        System.out.println("====count " + countNodesAtLevel(g, level));
        g.makeUnvisited();
        System.out.println("====count " + BFS(g, level));
    }
}
