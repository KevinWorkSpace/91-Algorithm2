package Advanced.Search;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDistance {

    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] res = new int[grid.length][grid[0].length];
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            for (int i=0; i<directions.length; i++) {
                int[] dir = directions[i];
                int newX = xy[0] + dir[0];
                int newY = xy[1] + dir[1];
                if (newX >=0 && newX < grid.length && newY >= 0 && newY < grid[0].length && res[newX][newY] == 0 && grid[newX][newY] == 0) {
                    queue.add(new int[]{newX, newY});
                    res[newX][newY] = res[xy[0]][xy[1]] + 1;
                }
            }
        }
        int max = 0;
        boolean f = true;
        for (int i=0; i<grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (res[i][j] > max) {
                    f = false;
                    max = res[i][j];
                }
            }
        }
        return f ? -1 : max;
    }
}
