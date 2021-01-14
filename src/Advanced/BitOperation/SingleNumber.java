package Advanced.BitOperation;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i=0; i<32; i++) {
            int bit = 1 << i;
            int cnt = 0;
            for (int num : nums) {
                if ((bit & num) != 0) {
                    cnt ++;
                }
            }
            if (cnt % 3 != 0) {
                res |= bit;
            }
        }
        if (res > Math.pow(2, 31) - 1) {
            res -= Math.pow(2, 32);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-2,1,1,4,1,4,4,-4,-2};
        SingleNumber number = new SingleNumber();
        System.out.println(number.singleNumber(nums));
    }
}
