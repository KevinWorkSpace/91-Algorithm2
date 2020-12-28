package Advanced.DP;

public class MaxSubArray2 {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int a = 0;
        for (int i=0; i<nums.length; i++) {
            a = nums[i];
            max = Math.max(max, a);
            for (int j=i+1; j<nums.length; j++) {
                a = a + nums[j];
                max = Math.max(max, a);
            }
        }
        return max;
    }
}
