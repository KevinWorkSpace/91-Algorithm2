package Advanced.BackTrace;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTrace(lists, path, candidates, target, 0, 0);
        return lists;
    }

    public void backTrace(List<List<Integer>> lists, List<Integer> path, int[] candidates, int target, int cur, int start) {
        if (cur == target) {
            lists.add(new ArrayList<>(path));
            return;
        }
        if (cur > target) return;
        for (int i=start; i<candidates.length; i++) {
            path.add(candidates[i]);
            cur += candidates[i];
            backTrace(lists, path, candidates, target, cur, i);
            path.remove(path.size()-1);
            cur -= candidates[i];
        }
    }
}
