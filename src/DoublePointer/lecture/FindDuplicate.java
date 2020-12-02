package DoublePointer.lecture;

public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int n = len - 1;
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }
            if (cnt > mid) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
}
