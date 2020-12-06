package Basic.DoublePointer.lecture;

public class RotateSearch {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        if (target <= nums[nums.length-1]) {
            int i = left;
            int j = nums.length-1;
            while (i <= j) {
                int mid = i + (j - i) / 2;
                if (nums[mid] > target) {
                    j = mid - 1;
                }
                else if (nums[mid] < target) {
                    i = mid + 1;
                }
                else return mid;
            }
            return -1;
        }
        else {
            int i = 0;
            int j = left - 1;
            while (i <= j) {
                int mid = i + (j - i) / 2;
                if (nums[mid] > target) {
                    j = mid - 1;
                }
                else if (nums[mid] < target) {
                    i = mid + 1;
                }
                else return mid;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3};
        int target = 1;
        RotateSearch search = new RotateSearch();
        int res = search.search(nums, target);
        System.out.println(res);
    }
}
