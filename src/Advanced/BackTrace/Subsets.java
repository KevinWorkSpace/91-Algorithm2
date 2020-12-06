package Advanced.BackTrace;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTrace(nums, 0, res, path);
        return res;
    }

    public void backTrace(int[] nums, int start, List<List<Integer>> res, List<Integer> path) {
        if (path.size() <= nums.length) {
            res.add(new ArrayList<>(path));
        }
        for (int i=start; i<nums.length; i++) {
            path.add(nums[i]);
            backTrace(nums, i+1, res, path);
            path.remove(path.size()-1);
        }
    }
}
