package Advanced.DP;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        for (int i=0; i<coins.length; i++) {
            if (coins[i] <= amount) {
                dp[coins[i]] = 1;
            }
        }
        for (int i=1; i<=amount; i++) {
            if (dp[i] == -1) {
                int minTemp = Integer.MAX_VALUE;
                for (int j=0; j<coins.length; j++) {
                    if (i - coins[j] > 0 && dp[i - coins[j]] != -1) {
                        if (minTemp > dp[i - coins[j]] + 1) {
                            minTemp = dp[i - coins[j]] + 1;
                        }
                    }
                }
                if (minTemp != Integer.MAX_VALUE) {
                    dp[i] = minTemp;
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;
        CoinChange coinChange = new CoinChange();
        int res = coinChange.coinChange(coins, amount);
    }
}
