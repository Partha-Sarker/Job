package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Kruskal {
    private Queue<Edge> edges = new PriorityQueue<>();
    private int size;

    private static class Edge implements Comparable<Edge> {
        int v1, v2, cost;

        Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.cost - edge.cost;
        }

        @Override
        public String toString() {
            return v1 + " " + v2 + " " + cost;
        }
    }

    public Kruskal(int size) {
        this.size = size;
    }

    public Kruskal(int[][] adjMat) {
        size = adjMat.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int cost = adjMat[i][j];
                if (cost != 0)
                    edges.offer(new Edge(i, j, cost));
            }
        }
    }

    public void addEdge(int a, int b, int cost) {
        Edge edge = new Edge(a, b, cost);
        edges.add(edge);
    }

    public void printMST() {
        List<Edge> mst = new ArrayList<>();
        int[] parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
        while (!edges.isEmpty()) {
            Edge currentEdge = edges.poll();
            int parentA = find(currentEdge.v1, parent);
            int parentB = find(currentEdge.v2, parent);
            if (parentA == parentB)
                continue;
            parent[parentA] = parentB;
            mst.add(currentEdge);
        }
        for (Edge edge : mst) {
            System.out.println(edge);
        }
    }

    private int find(int a, int[] parent) {
        if (a == parent[a])
            return a;
        return parent[a] = find(parent[a], parent);
    }

    public static void main(String[] args) {
        Kruskal kruskal = new Kruskal(new int[][]{
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}});
        kruskal = new Kruskal(5);
        kruskal.addEdge(0, 1, 2);
        kruskal.addEdge(0, 3, 6);
        kruskal.addEdge(1, 2, 3);
        kruskal.addEdge(1, 3, 8);
        kruskal.addEdge(1, 4, 5);
        kruskal.addEdge(2, 4, 7);
        kruskal.addEdge(3, 4, 9);
        kruskal.printMST();
    }

}
