package Advanced.BitOperation;

public class FindErrorNums {

    public int[] findErrorNums(int[] nums) {
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum ^= nums[i] ^ (i + 1);
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
        for (int i=1; i<=nums.length; i++) {
            if ((i & h) != 0) {
                a ^= i;
            }
            else b ^= i;
        }
        int cnt = 0;
        for (int num : nums) {
            if (a == num) {
                cnt ++;
            }
        }
        if (cnt == 0) {
            return new int[]{b, a};
        }
        else return new int[]{a, b};
    }

    public static void main(String[] args) {
        FindErrorNums findErrorNums = new FindErrorNums();
        int[] res = findErrorNums.findErrorNums(new int[]{3,2,3,4,6,5});
    }
}
