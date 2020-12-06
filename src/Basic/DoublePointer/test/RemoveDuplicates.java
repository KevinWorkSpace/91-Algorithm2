package Leetcode;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int j = 0;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[j]) {
                len --;
            }
            else {
                nums[++j] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicates duplicates = new RemoveDuplicates();
        int res = duplicates.removeDuplicates(nums);
    }
}
