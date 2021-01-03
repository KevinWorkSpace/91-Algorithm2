package Basic.Array.lecture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDisappearedNumbers2 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (nums[Math.abs(num)-1] > 0) {
                nums[Math.abs(num)-1] = -nums[Math.abs(num)-1];
            }
        }
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i+1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        FindDisappearedNumbers2 numbers = new FindDisappearedNumbers2();
        List<Integer> list = numbers.findDisappearedNumbers(nums);
    }
}
