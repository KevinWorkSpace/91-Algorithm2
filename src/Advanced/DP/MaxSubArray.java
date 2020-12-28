package Advanced.DP;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i=0; i<dp.length; i++) {
            dp[i] = nums[i];
            max = Math.max(max, dp[i]);
            for (int j=i+1; j<dp.length; j++) {
                dp[j] = dp[j-1] + nums[j];
                max = Math.max(max, dp[j]);
            }
        }
        return max;
    }
}
