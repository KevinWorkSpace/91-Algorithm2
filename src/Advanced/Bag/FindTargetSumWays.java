package Advanced.Bag;

public class FindTargetSumWays {

    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
        }
        if (S > sum) return 0;
        int[][] dp = new int[nums.length][sum * 2 + 1];
        dp[0][nums[0] + sum] += 1;
        dp[0][sum - nums[0]] += 1;
        for (int i=1; i<nums.length; i++) {
            for (int j=0; j<dp[0].length; j++) {
                if (j + nums[i] < dp[0].length) {
                    dp[i][j] += dp[i-1][j+nums[i]];
                }
                if (j - nums[i] >= 0) {
                    dp[i][j] += dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[nums.length-1][S+sum];
    }
}
