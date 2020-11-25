package DoublePointer.test;

public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[nums.length-1] < target) return nums.length;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        SearchInsert searchInsert = new SearchInsert();
        int res = searchInsert.searchInsert(nums, target);
        System.out.println(res);
    }
}
