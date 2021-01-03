package Advanced.DP;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDistance {

    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        boolean[][] visit = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    res[i][j] = 0;
                    visit[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }
        int[] tmp = null;
        int[][] d = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            tmp = queue.poll();
            for (int k=0; k<d.length; k++) {
                int dx = tmp[0] + d[k][0];
                int dy = tmp[1] + d[k][1];
                if (dx >= 0 && dx < m && dy >= 0 && dy < n && !visit[dx][dy]) {
                    visit[dx][dy] = true;
                    res[dx][dy] = res[tmp[0]][tmp[1]] + 1;
                    queue.add(new int[]{dx, dy});
                }
            }
        }
        if (tmp == null) return -1;
        if (res[tmp[0]][tmp[1]] == 0) return -1;
        return res[tmp[0]][tmp[1]];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        MaxDistance maxDistance = new MaxDistance();
        System.out.println((2<<4) + (40>>2));
        System.out.println(40 >> 2);
        System.out.println(maxDistance.maxDistance(grid));
    }
}
