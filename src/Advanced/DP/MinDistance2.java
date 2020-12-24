package Advanced.DP;

public class MinDistance2 {

    public int minDistance(String word1, String word2) {
        int[] dp = new int[word2.length() + 1];
        for (int i=1; i<dp.length; i++) {
            dp[i] = dp[i-1] + 1;
        }
        for (int i=1; i<=word1.length(); i++) {
            int tmp = dp[0];
            dp[0] = i;
            for (int j=1; j<=word2.length(); j++) {
                int pre = tmp;
                tmp = dp[j];
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[j] = pre;
                }
                else {
                    dp[j] = Math.min(dp[j-1], Math.min(dp[j], pre)) + 1;
                }
            }
        }
        return dp[word2.length()];
    }
}
