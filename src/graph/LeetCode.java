package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode {
    public static void main(String[] args) {
        LeetCode code = new LeetCode();
        int[][] grid = {{0, 6, 0}, {5, 8, 7}, {0, 9, 7}};
    }

    public int numIslands(char[][] grid) {
//        200. Number of Islands
        int rowSize, colSize;
        boolean visited[][];
        rowSize = grid.length;
        colSize = grid[0].length;
        visited = new boolean[rowSize][colSize];
        int isLandCount = 0;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (visited[i][j] || grid[i][j] == '0')
                    continue;
                visitLand(grid, i, j, rowSize, colSize, visited);
                isLandCount++;
            }
        }
        return isLandCount;
    }

    private void visitLand(char[][] grid, int i, int j, int rowSize, int colSize, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= rowSize || j >= colSize)
            return;
        if (visited[i][j] || grid[i][j] == '0')
            return;
        visited[i][j] = true;
        visitLand(grid, i - 1, j, rowSize, colSize, visited);
        visitLand(grid, i + 1, j, rowSize, colSize, visited);
        visitLand(grid, i, j + 1, rowSize, colSize, visited);
        visitLand(grid, i, j - 1, rowSize, colSize, visited);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int goalNode = graph.length - 1;
        List<Integer> currentPath = new ArrayList<>();

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            if (currentNode == goalNode)
                break;
            currentPath.add(currentNode);
            for (int neighbor : graph[currentNode]) {
                queue.add(neighbor);
                if (neighbor == goalNode) {
                    List<Integer> successPath = new ArrayList<>(currentPath);
                    successPath.add(neighbor);
                    paths.add(successPath);
                }
            }
        }
        return paths;
    }
}
