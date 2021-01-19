package Basic.DoublePointer.lecture;

public class Exchange {

    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while (left <= right){
            int n = nums[i];
            if ((n & 1) == 0) {
                int tmp = nums[right];
                nums[right--] = n;
                nums[i] = tmp;
            }
            else {
                left ++;
                i ++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        Exchange exchange = new Exchange();
        exchange.exchange(nums);
    }
}
