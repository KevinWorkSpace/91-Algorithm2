package Advanced.DP;

public class Rob2 {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int a = 0;
        int b = nums[0];
        int max = b;
        for (int i=2; i<=nums.length; i++) {
            max = Math.max(b, a + nums[i-1]);
            a = b;
            b = max;
        }
        return max;
    }

    public static void main(String[] args) {
        Rob2 rob = new Rob2();
        int[] nums = {1};
        System.out.println(rob.rob(nums));
    }
}
