package Advanced.BackTrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        backTrace(res, path, nums, 0);
        return res;
    }

    public void backTrace(List<List<Integer>> res, List<Integer> path, int[] nums, int start) {
        if (!res.contains(path)) {
            res.add(new ArrayList<>(path));
        }
        for (int i=start; i<nums.length; i++) {
            path.add(nums[i]);
            backTrace(res, path, nums, i+1);
            path.remove(path.size()-1);
        }
    }
}
