package Advanced.BackTrace;

import java.util.ArrayList;
import java.util.List;

public class Subsets3 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTrace(nums, res, path, 0);
        return res;
    }

    public void backTrace(int[] nums, List<List<Integer>> res, List<Integer> path, int i) {
        res.add(new ArrayList<>(path));
        for (int j=i; j<nums.length; j++) {
            path.add(nums[j]);
            backTrace(nums, res, path, j+1);
            path.remove(path.size() - 1);
        }
    }
}
