package Advanced.DP;

import java.util.LinkedList;
import java.util.Queue;

public class UpdateMatrix {

    public int[][] updateMatrix(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];
        boolean[][] visit = new boolean[matrix.length][matrix[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    res[i][j] = 0;
                    visit[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }
        int[][] d = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            for (int k=0; k<d.length; k++) {
                int dx = tmp[0] + d[k][0];
                int dy = tmp[1] + d[k][1];
                if (dx >= 0 && dx < matrix.length && dy >=0 && dy < matrix[0].length) {
                    if (!visit[dx][dy]) {
                        res[dx][dy] = res[tmp[0]][tmp[1]] + 1;
                        visit[dx][dy] = true;
                        queue.add(new int[]{dx, dy});
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,0,0},
                    {0,1,0},
                    {1,1,1}};
        UpdateMatrix updateMatrix = new UpdateMatrix();
        int[][] res = updateMatrix.updateMatrix(matrix);
    }
}
