package Basic.DoublePointer.lecture;

public class Exchange2 {

    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            while (left < nums.length && (nums[left] & 1) != 0) {
                left ++;
            }
            while (right >= 0 && (nums[right] & 1) == 0) {
                right --;
            }
            if (left > right) break;
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        Exchange2 exchange = new Exchange2();
        exchange.exchange(nums);
    }
}
