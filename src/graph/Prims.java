package graph;

import java.util.Arrays;

public class Prims {
    private int[][] adjMat;

    public Prims(int n) {
        adjMat = new int[n][n];
    }

    public Prims(int[][] adjMat) {
        this.adjMat = adjMat;
    }

    public void printMST() {
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
            if (parent[i] == i)
                continue;
            System.out.println(i + " " + parent[i] + " " + adjMat[i][parent[i]]);
        }
    }

    private void relaxAdjacentNodes(int node, boolean[] visited, int[] distArray, int[] parent) {
        for (int i = 0; i < visited.length; i++) {
            int weight = adjMat[node][i];
            if (weight != 0 && !visited[i]) {
                if (distArray[i] > weight) {
                    distArray[i] = weight;
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
        Prims prims = new Prims(new int[][]{
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}});
        prims.printMST();
    }
}
