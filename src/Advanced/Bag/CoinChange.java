package Advanced.Bag;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[][] dp = new int[coins.length][amount + 1];
        int c = coins[0];
        Arrays.fill(dp[0], amount+1);
        for (int i=0; i<=amount; i++) {
            if (c * i > amount) break;
            dp[0][c * i] = i;
        }
        for (int i=1; i<coins.length; i++) {
            for (int j=0; j<=amount; j++) {
                if (j - coins[i] >= 0) {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i]] + 1);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[coins.length-1][amount] == amount+1 ? -1 : dp[coins.length-1][amount];
    }
}
