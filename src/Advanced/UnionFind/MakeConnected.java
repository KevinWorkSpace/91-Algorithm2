package Advanced.UnionFind;

public class MakeConnected {

    private int[] parent;
    private int[] size;
    private int cnt;

    public int makeConnected(int n, int[][] connections) {
        parent = new int[n];
        size = new int[n];
        cnt = n;
        for (int i=0; i<n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int i=0; i<connections.length; i++) {
            union(connections[i][0], connections[i][1]);
        }
        int rope = connections.length;
        if (rope >= n - 1) {
            return cnt - 1;
        }
        else {
            return -1;
        }
    }

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) return;
        if (size[xRoot] >= size[yRoot]) {
            parent[yRoot] = xRoot;
            size[xRoot] += size[yRoot];
        }
        else {
            parent[xRoot] = yRoot;
            size[yRoot] += size[xRoot];
        }
        cnt --;
    }

}
