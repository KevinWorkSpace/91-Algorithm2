package DoublePointer.lecture;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res = 0;
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < min) {
                    min = Math.abs(sum - target);
                    res = sum;
                }
                if (sum > target) {
                    int tmp = right - 1;
                    while (tmp > left && nums[tmp] == nums[right]) {
                        tmp --;
                    }
                    right = tmp;
                }
                else if (sum < target) {
                    int tmp = left + 1;
                    while (tmp < right && nums[tmp] == nums[left]) {
                        tmp ++;
                    }
                    left = tmp;
                }
                else return sum;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0};
        int target = -100;
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int res = threeSumClosest.threeSumClosest(nums, target);
    }
}
