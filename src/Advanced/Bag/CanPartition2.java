package Advanced.Bag;

public class CanPartition2 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
        }
        if ((sum & 1) != 0) {
            return false;
        }
        int target = sum >> 1;
        int[] dp = new int[target+1];
        dp[0] = 1;
        if (nums[0] <= target) {
            dp[nums[0]] = 1;
        }
        if (dp[target] == 1) return true;
        for (int i=1; i<nums.length; i++) {
            for (int j=target; j>=0; j--) {
                if (dp[j] == 1 && j + nums[i] <= target) {
                    dp[j + nums[i]] = 1;
                }
            }
            if (dp[target] == 1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        CanPartition2 canPartition2 = new CanPartition2();
        System.out.println(canPartition2.canPartition(nums));
    }
}
