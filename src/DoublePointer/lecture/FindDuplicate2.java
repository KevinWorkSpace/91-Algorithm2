package DoublePointer.lecture;

public class FindDuplicate2 {

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        FindDuplicate2 duplicate2 = new FindDuplicate2();
        duplicate2.findDuplicate(nums);
    }
}
