package DoublePointer.lecture;

public class SortedSquares {

    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int[] res = new int[nums.length];
        int index = nums.length - 1;
        while (i <= j) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                res[index--] = nums[i] * nums[i];
                i ++;
            }
            else {
                res[index--] = nums[j] * nums[j];
                j --;
            }
        }
        return res;
    }
}
