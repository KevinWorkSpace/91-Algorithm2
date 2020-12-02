package DoublePointer.lecture;

public class RemoveDuplicatesII2 {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int j = 0;
        for (int num : nums) {
            if (j < 2) {
                j ++;
            }
            else if (nums[j-2] != num) {
                nums[j++] = num;
            }
        }
        return j;
    }

    public static void main(String[] args) {
//        int[] nums = {0,0,1,1,1,1,2,3,3};
        int[] nums = {1,1,1,1,2,2,3};
        RemoveDuplicatesII2 removeDuplicatesII = new RemoveDuplicatesII2();
        int len = removeDuplicatesII.removeDuplicates(nums);
    }
}
