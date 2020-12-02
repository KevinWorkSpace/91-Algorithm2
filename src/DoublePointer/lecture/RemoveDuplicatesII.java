package DoublePointer.lecture;

public class RemoveDuplicatesII {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int j = 1;
        for (int i=2; i<nums.length; i++) {
            if (nums[i] != nums[j-1]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
//        int[] nums = {0,0,1,1,1,1,2,3,3};
        int[] nums = {1,1,1,1,2,2,3};
        RemoveDuplicatesII removeDuplicatesII = new RemoveDuplicatesII();
        int len = removeDuplicatesII.removeDuplicates(nums);
    }
}
