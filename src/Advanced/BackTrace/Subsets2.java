package Advanced.BackTrace;

import java.util.ArrayList;
import java.util.List;

public class Subsets2 {

    public List<List<Integer>> subsets(int[] nums) {
        int size = 1 << nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0; i<size; i++) {
            List<Integer> path = new ArrayList<>();
            for (int j=0; j<nums.length; j++) {
                if (((i >> j) & 1) == 1) {
                    path.add(nums[j]);
                }
            }
            res.add(path);
        }
        return res;
    }
}
