package HashTable.test;

import java.util.HashMap;

public class TwoSum {

    HashMap<Integer, Integer> map = new HashMap<>();

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i=0; i<nums.length; i++) {
            int tmp = nums[i];
            if (map.containsKey(target - tmp)) {
                res[0] = map.get(target - tmp);
                res[1] = i;
                break;
            }
            else map.put(nums[i], i);
        }
        return res;
    }
}
