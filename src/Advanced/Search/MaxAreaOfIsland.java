package Advanced.Search;

public class MaxAreaOfIsland {

    int[][] vis = null;
    int count = 0;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) return 0;
        vis = new int[grid.length][grid[0].length];
        int max = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    count = 0;
                    dfs(i, j, grid);
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }

    public void dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        if (vis[i][j] == 1 || grid[i][j] == 0) return;
        vis[i][j] = 1;
        count ++;
        dfs(i-1, j, grid);
        dfs(i+1, j, grid);
        dfs(i, j-1, grid);
        dfs(i, j+1, grid);
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0,0},
                        {1,1,0,0,0},
                        {0,0,0,1,1},
                        {0,0,0,1,1}};
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        System.out.println(maxAreaOfIsland.maxAreaOfIsland(grid));
    }
}
