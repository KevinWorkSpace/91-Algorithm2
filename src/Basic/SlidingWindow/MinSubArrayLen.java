package Basic.SlidingWindow;

public class MinSubArrayLen {

    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (int right=0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= s) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left++];
            }
        }
        if (res == Integer.MAX_VALUE) return 0;
        return res;
    }
}
