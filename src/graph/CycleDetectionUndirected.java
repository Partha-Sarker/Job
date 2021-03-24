package graph;

import java.util.*;

public class CycleDetectionUndirected {
    private Set<Integer>[] adjList;

    CycleDetectionUndirected(int n) {
        adjList = new HashSet[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new HashSet<>();
        }
    }

    public void addEdge(int a, int b) {
        adjList[a].add(b);
        adjList[b].add(a);
    }

    public boolean hasCycle() {
        int len = adjList.length;
        boolean[] visited = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                if (bfs(i, adjList, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasCycleV2() {
        boolean[] visited = new boolean[adjList.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                if (dfsCheck(i, visited, adjList, -1))
                    return true;
            }
        }
        return false;
    }

    public boolean hasCycleV3() {
        int len = adjList.length;
        int[] parent = new int[len];
        for (int i = 0; i < len; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < len; i++) {
            int parentA = find(i, parent);
            for (int node : adjList[i]) {
                if (node <= i)
                    continue;
                int parentB = find(node, parent);
                if (parentA == parentB)
                    return true;
                parent[parentB] = parentA;
            }
        }
        return false;
    }

    private int find(int node, int[] parent) {
        if (node == parent[node])
            return node;
        return parent[node] = find(parent[node], parent);
    }

    private boolean dfsCheck(int node, boolean[] visited, Set<Integer>[] adj, int parent) {
        visited[node] = true;
        for (int newNode : adj[node]) {
            if (visited[newNode]) {
                if (newNode != parent)
                    return true;
            }
            else if (dfsCheck(newNode, visited, adj, node))
                return true;
        }
        return false;
    }

    private boolean bfs(int node, Set<Integer>[] adjList, boolean[] visited) {
        int[] parent = new int[visited.length];
        visited[node] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int newNode : adjList[currentNode]) {
                    if (newNode == parent[newNode])
                        continue;
                    if (visited[newNode])
                        return true;
                    visited[newNode] = true;
                    queue.offer(newNode);
                    parent[newNode] = currentNode;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CycleDetectionUndirected cD = new CycleDetectionUndirected(3);
        cD.addEdge(0, 1);
        cD.addEdge(0, 2);
//        cD.addEdge(1, 2);
//        cD.addEdge(2, 0);
        System.out.println(cD.hasCycleV3());
    }
}
