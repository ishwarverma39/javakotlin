package com.livtech.demo.datastructure.graph.common;

import java.util.LinkedList;
import java.util.Queue;

public class GraphAList {
    private final LinkedList<Integer>[] list;
    private final int vCount;
    private final boolean[] visited;
    public final char[] vertices;

    public GraphAList(int vCount, char[] vertices) {
        this.vCount = vCount;
        this.list = new LinkedList[vCount];
        for (int i = 0; i < vCount; i++) {
            list[i] = new LinkedList<>();
        }
        visited = new boolean[vCount];
        this.vertices = vertices;
    }


    public int getVCount() {
        return vCount;
    }

    public LinkedList<Integer>[] getList() {
        return list;
    }

    public LinkedList<Integer> getAdjacencyList(int v){
        return list[v];
    }

    public boolean isVisited(int v) {
        return visited[v];
    }

    public void makeVisited(int v) {
        visited[v] = true;
    }

    public void addEdge(int u, int v) {
        addEdge(u, v, true);
    }

    public void addEdge(int u, int v, boolean directed) {
        list[u].add(v);
        if (!directed) list[v].add(u);
    }

    public void display(int v) {
        System.out.print(" " + vertices[v]);
    }

    public void makeUnvisited() {
        for (int i = 0; i < vCount; i++) visited[i] = false;
    }

    public void makeUnvisited(int i) {
        visited[i] = false;
    }

    public void DFS(int v) {
        for (int i = 0; i < vCount; i++) {
            if (!isVisited(i)) DFSUtils(i);
        }
    }

    private void DFSUtils(int v) {
        visited[v] = true;
        display(v);
        for (Integer next : list[v]) {
            if (!visited[next])
                DFSUtils(next);
        }
    }

    public void BFS(int v) {
        for (int i = 0; i < vCount; i++) {
            if (!isVisited(i)) BFSUtils(i);
        }
    }

    private void BFSUtils(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        while (!queue.isEmpty()) {
            v = queue.remove();
            visited[v] = true;
            display(v);
            for (Integer next : list[v]) {
                if (!visited[next]) {
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphAList graph = new GraphAList(8, new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'});
        graph.addEdge(0, 1); //A -> B
        graph.addEdge(1, 2); //B -> C
        graph.addEdge(1, 7); //B -> H
        graph.addEdge(2, 3); //C -> D
        graph.addEdge(2, 4); //C -> E
        graph.addEdge(4, 5); //E -> F
        graph.addEdge(4, 6); //E -> G
        graph.addEdge(4, 7); //E -> H
        System.out.println("===DFS===");
        graph.DFS(0);
        graph.makeUnvisited();

        System.out.println("\n====BFS=====");
        graph.BFS(0);
        graph.makeUnvisited();
    }
}
