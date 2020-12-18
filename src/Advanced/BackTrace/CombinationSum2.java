package Advanced.BackTrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
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
            if (i != start && candidates[i] == candidates[i-1]) continue;
            path.add(candidates[i]);
            cur += candidates[i];
            backTrace(lists, path, candidates, target, cur, i+1);
            path.remove(path.size()-1);
            cur -= candidates[i];
        }
    }


}
