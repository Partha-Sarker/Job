package graph;

public class FloydWarshall {
    int[][] adjMat;

    public FloydWarshall(int[][] adjMat) {
        this.adjMat = adjMat;
    }

    public void calculateDistance() {
        int size = adjMat.length;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    if (i == k || i == j) {
                        continue;
                    }
                    int first = adjMat[i][k];
                    int second = adjMat[k][j];
                    if (first == Integer.MAX_VALUE || second == Integer.MAX_VALUE)
                        continue;
                    if (first + second < adjMat[i][j])
                        adjMat[i][j] = first + second;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int value = adjMat[i][j];
                if (value == Integer.MAX_VALUE)
                    value = -1;
                System.out.print(String.format("%3s", value));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]
                {{0, 5, Integer.MAX_VALUE, 10},
                        {Integer.MAX_VALUE, 0, 3, Integer.MAX_VALUE},
                        {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 1},
                        {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}};
        FloydWarshall fw = new FloydWarshall(graph);
        fw.calculateDistance();
    }
}
