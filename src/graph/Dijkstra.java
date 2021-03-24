package graph;

import java.util.Arrays;

public class Dijkstra {
    private int[][] adjMat;

    public Dijkstra(int n) {
        adjMat = new int[n][n];
    }

    public Dijkstra(int[][] adjMat) {
        this.adjMat = adjMat;
    }

    public void calculateDijkstra() {
        int len = adjMat.length;
        boolean[] visited = new boolean[len];
        int[] distArray = new int[len], parent = new int[len];
        for (int i = 0; i < len; i++) {
            parent[i] = i;
        }
        distArray = Arrays.stream(distArray).map(x -> Integer.MAX_VALUE).toArray();
        distArray[0] = 0;

        for (int i = 0; i < len - 1; i++) {
            int currentNode = getMinWeightNode(visited, distArray);
            relaxAdjacentNodes(currentNode, visited, distArray, parent);
            visited[currentNode] = true;
        }

        for (int i = 0; i < len; i++) {
            System.out.println(i + " " + distArray[i]);
        }
    }

    private void relaxAdjacentNodes(int node, boolean[] visited, int[] distArray, int[] parent) {
        for (int i = 0; i < visited.length; i++) {
            int weight = adjMat[node][i];
            int currentWeight = distArray[node];
            if (weight != 0 && !visited[i]) {
                if (distArray[i] > currentWeight + weight) {
                    distArray[i] = currentWeight + weight;
                    parent[i] = node;
                }
            }
        }
    }

    private int getMinWeightNode(boolean[] visited, int[] distanceArray) {
        int minIndex = -1, minValue = Integer.MAX_VALUE;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && distanceArray[i] < minValue) {
                minIndex = i;
                minValue = distanceArray[i];
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        Dijkstra prims = new Dijkstra(new int[][]{
                { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 }});
        prims.calculateDijkstra();
    }
}
