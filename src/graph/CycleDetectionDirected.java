package graph;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectionDirected {
    private List<List<Integer>> adj;
    private int cycleStart = -1, cycleEnd = -1;
    private int[] parent;

    CycleDetectionDirected(int count) {
        adj = new ArrayList<>(count);
        while (count-- != 0) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int a, int b) {
        adj.get(a).add(b);
    }

    public boolean hasCycle() {
        // 0 -> white, 1 -> gray, 2 -> black
        cycleEnd = cycleStart = -1;
        int[] color = new int[adj.size()];
        parent = new int[adj.size()];

        for (int i = 0; i < color.length; i++) {
            if (color[i] == 0) {
                boolean isCyclic = dfsCheckWithColor(i, color, adj, parent);
                if (isCyclic) {
                    printCycle(cycleEnd);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsCheckWithColor(int node, int[] color, List<List<Integer>> adj, int[] parent) {
        color[node] = 1;
        for (int newNode : adj.get(node)) {
            if (color[newNode] == 2)
                continue;
            if (color[newNode] == 1) {
                cycleStart = newNode;
                cycleEnd = node;
                return true;
            }
            parent[newNode] = node;
            if (dfsCheckWithColor(newNode, color, adj, parent))
                return true;
        }
        color[node] = 2;
        return false;
    }

    public boolean hasCycleV2() {
        int size = adj.size();
        boolean[] visited = new boolean[size], recStack = new boolean[size];
        parent = new int[size];

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                boolean isCyclic = isCyclic(i, recStack, visited, adj);
                if (isCyclic)
                    return true;
            }
        }
        return false;
    }

    private boolean isCyclic(int node, boolean[] recStack, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;
        recStack[node] = true;

        for (int nextNode : adj.get(node)) {
            if (recStack[nextNode])
                return true;
            if (!visited[nextNode] && isCyclic(nextNode, recStack, visited, adj))
                return true;
        }

        recStack[node] = false;
        return false;
    }

    public void printCycle(int node) {
        if (node == cycleStart) {
            System.out.print(node + " ");
            return;
        }
        printCycle(parent[node]);
        System.out.print(node + " ");
    }

    public static void main(String[] args) {
        CycleDetectionDirected cD = new CycleDetectionDirected(3);
        cD.addEdge(0, 1);
        cD.addEdge(0, 2);
        cD.addEdge(1, 2);
//        cD.addEdge(2, 0);
//        cD.addEdge(2, 3);
        System.out.println(cD.hasCycleV2());
    }
}
