package DoublePointer.lecture;

import com.sun.xml.internal.bind.v2.util.StackRecorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        List<List<Integer>> lists = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    int tmp = left + 1;
                    while (tmp < right && nums[tmp] == nums[left]) {
                        tmp ++;
                    }
                    left = tmp;
                }
                else if (sum < 0) {
                    int tmp = left + 1;
                    while (tmp < right && nums[tmp] == nums[left]) {
                        tmp ++;
                    }
                    left = tmp;
                }
                else {
                    int tmp = right - 1;
                    while (tmp > left && nums[tmp] == nums[right]) {
                        tmp --;
                    }
                    right = tmp;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(nums);
    }
}
