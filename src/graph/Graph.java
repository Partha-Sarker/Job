package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    int nodeCount;
    ArrayList<Integer> adjacencyList[];

    Graph(int nodeCount) {
        this.nodeCount = nodeCount;
        adjacencyList = new ArrayList[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int n1, int n2) {
        adjacencyList[n1].add(n2);
    }

    public void generalBFS(int source, int target) {
        boolean[] visited = new boolean[nodeCount];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        int distance = 0;
        while (!queue.isEmpty()) {
            int top = queue.poll();
            visited[top] = true;
            for (int node : adjacencyList[top]) {
                if (visited[node])
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
    }
}
