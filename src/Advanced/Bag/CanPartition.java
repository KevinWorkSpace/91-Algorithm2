package Advanced.Bag;

public class CanPartition {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
        }
        if ((sum & 1) != 0) {
            return false;
        }
        int target = sum >> 1;
        int[][] dp = new int[nums.length][target+1];
        dp[0][0] = 1;
        if (nums[0] <= target) {
            dp[0][nums[0]] = 1;
        }
        if (dp[0][target] == 1) return true;
        for (int i=1; i<nums.length; i++) {
            for (int j=0; j<=target; j++) {
                if (dp[i-1][j] == 1) {
                    dp[i][j] = 1;
                    if (j + nums[i] <= target) {
                        dp[i][j + nums[i]] = 1;
                    }
                }
            }
            if (dp[i][target] == 1) return true;
        }
        return false;
    }
}
