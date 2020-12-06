package Basic.DoublePointer.lecture;

public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[2];
        if (nums.length == 0) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            res[0] = left;
        }
        else res[0] = -1;
        left = 0;
        right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                left = mid;
            }
        }
        if (left == nums.length) {
            res[1] = -1;
        }
        else if (nums[left] == target) {
            res[1] = left;
        }
        else res[1] = -1;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2};
        int target = 3;
        SearchRange searchRange = new SearchRange();
        int[] res = searchRange.searchRange(nums, target);
    }
}
