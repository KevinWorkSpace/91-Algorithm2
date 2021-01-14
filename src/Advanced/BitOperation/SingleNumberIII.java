package Advanced.BitOperation;

public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum ^= nums[i];
        }
        int h = 1;
        while ((h & sum) == 0) {
            h = h << 1;
        }
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & h) != 0) {
                a ^= num;
            }
            else b ^= num;
        }
        return new int[]{a, b};
    }
}
