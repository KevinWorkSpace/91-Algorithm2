package Advanced.UnionFind;

public class FindCircleNum {

    int cnt = 0;
    int[] parent;
    int[] size;

    public int findCircleNum(int[][] M) {
        parent = new int[M.length];
        cnt = M.length;
        size = new int[M.length];
        for (int i=0; i<parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int i=0; i<M.length; i++) {
            for (int j=i; j<M[0].length; j++) {
                if (M[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        return cnt;
    }

    public int find(int x) {
        if (parent[x] != x) {
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
            size[yRoot] += size[xRoot];
        }
        else {
            parent[xRoot] = yRoot;
            size[xRoot] += size[yRoot];
        }
        cnt --;
    }


}
