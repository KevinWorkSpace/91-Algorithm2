package Advanced.Bag;

import java.util.Arrays;

public class CoinChange2 {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        int c = coins[0];
        Arrays.fill(dp, amount+1);
        for (int i=0; i<=amount; i++) {
            if (c * i > amount) break;
            dp[c * i] = i;
        }
        for (int i=1; i<coins.length; i++) {
            for (int j=0; j<=amount; j++) {
                if (j - coins[i] >= 0) {
                    dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
                }
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}
