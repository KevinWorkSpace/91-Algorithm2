package Advanced.BitOperation;

public class SingleNumber2 {

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i=0; i<nums.length; i++) {
            xor ^= nums[i];
        }
        int i = 1;
        while ((xor & i) == 0) {
            i = i << 1;
        }
        int[] res = new int[2];
        for (int j=0; j<nums.length; j++) {
            if ((nums[j] & i) == 0) {
                res[0] ^= nums[j];
            }
            else {
                res[1] ^= nums[j];
            }
        }
        return res;
    }
}
