package Advanced.DP;

public class Rec_subset {

    public boolean rec_subset(int[] nums, int s) {
        return helper(nums, nums.length-1, s);
    }

    public boolean helper(int[] nums, int i, int s) {
        if (i == 0 && nums[i] != s) return false;
        if (i == 0 && nums[i] == s) return true;
        if (s == 0) return true;
        if (nums[i] > s) return helper(nums, i-1, s);
        return helper(nums, i-1, s) || helper(nums, i-1, s-nums[i]);
    }

    public static void main(String[] args) {
        Rec_subset rec_subset = new Rec_subset();
        int[] nums = {3, 34, 4, 12, 5, 2};
        int s = 12;
        System.out.println(rec_subset.rec_subset(nums, s));
    }
}
