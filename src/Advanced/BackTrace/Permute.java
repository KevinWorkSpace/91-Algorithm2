package Advanced.BackTrace;

import java.util.ArrayList;
import java.util.List;

public class Permute {

    public List<List<Integer>> permute(int[] nums) {
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
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                backTrace(lists, path, nums, used);
                path.remove(path.size()-1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permute permute = new Permute();
        List<List<Integer>> lists = permute.permute(nums);
        System.out.println(lists);
    }
}
