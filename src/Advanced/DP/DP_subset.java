package Advanced.DP;

public class DP_subset {

    public boolean dp_subset(int[] nums, int s) {
        boolean[][] dp = new boolean[nums.length][s+1];
        if (nums[0] < s) {
            dp[0][nums[0]] = true;
            dp[0][0] = true;
        }
        for (int i=1; i<nums.length; i++) {
            for (int j=0; j<dp[0].length; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                    if (j + nums[i] <= s) {
                        dp[i][j+nums[i]] = true;
                    }
                }
            }
        }
        return dp[nums.length-1][s];
    }

    public static void main(String[] args) {
        DP_subset dp_subset = new DP_subset();
        int[] nums = {3, 34, 4, 12, 5, 2};
        int s = 9;
        System.out.println(dp_subset.dp_subset(nums, s));
    }
}
