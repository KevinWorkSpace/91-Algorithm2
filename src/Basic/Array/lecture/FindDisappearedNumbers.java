package Basic.Array.lecture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int cur = 1;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == cur) {
                cur ++;
            }
            else if (nums[i] < cur) {
                continue;
            }
            else {
                while (nums[i] > cur) {
                    list.add(cur);
                    cur ++;
                }
                cur ++;
            }
        }
        while (cur <= nums.length) {
            list.add(cur);
            cur ++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        FindDisappearedNumbers numbers = new FindDisappearedNumbers();
        List<Integer> list = numbers.findDisappearedNumbers(nums);
    }
}
