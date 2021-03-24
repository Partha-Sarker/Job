package datastructure;

public class DisjointSet {
    int[] parent, rank;

    public DisjointSet(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++)
            parent[i] = i;
    }

    public void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA == parentB)
            return;
        if (rank[parentA] > rank[parentB])
            parent[parentB] = parentA;
        else if (rank[parentA] < rank[parentB])
            parent[parentA] = parentB;
        else {
            parent[parentB] = parentA;
            rank[parentA]++;
        }
    }

    private int find(int a) {
        if (a == parent[a])
            return a;
        return parent[a] = find(parent[a]);
    }

    public boolean checkCycle(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA == parentB)
            return true;
        return false;
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(5);
        ds.union(0, 2);
        ds.union(4, 2);
        ds.union(3, 1);
        System.out.println(ds.checkCycle(2, 1));
        ds.union(2, 1);
        System.out.println(ds.checkCycle(3, 4));
    }
}
