package Advanced.DP;

public class MaxValue {

    public int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i=1; i<dp[0].length; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int j=1; j<dp.length; j++) {
            dp[j][0] = dp[j-1][0] + grid[j][0];
        }
        for (int i=1; i<dp.length; i++) {
            for (int j=1; j<dp[0].length; j++) {
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]) + grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
