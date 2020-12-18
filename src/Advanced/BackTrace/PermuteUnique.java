package Advanced.BackTrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTrace(lists, path, nums, used);
        return lists;
    }

    public void backTrace(List<List<Integer>> lists, List<Integer> path, int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            lists.add(new ArrayList<>(path));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1] && !used[i]) {
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                backTrace(lists, path, nums, used);
                used[i] = false;
                path.remove(path.size()-1);
            }
        }
    }
}
