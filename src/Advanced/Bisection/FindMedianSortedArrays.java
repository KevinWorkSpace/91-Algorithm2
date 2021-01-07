package Advanced.Bisection;

public class FindMedianSortedArrays {

    int count = 0;
    int n1 = 0;
    int n2 = 0;
    int mid = 0;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l = 0;
        int r = 0;
        mid = (nums1.length + nums2.length) / 2;
        while (l < nums1.length && r < nums2.length) {
            if (nums1[l] <= nums2[r]) {
                helper(nums1, l);
                l ++;
            }
            else {
                helper(nums2, r);
                r ++;
            }
        }
        while (l < nums1.length) {
            helper(nums1, l);
            l ++;
        }
        while (r < nums2.length) {
            helper(nums2, r);
            r ++;
        }
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (double) (n1 + n2) / 2;
        }
        else return n2;
    }

    public void helper(int[] nums, int p) {
        count ++;
        if (count == mid) {
            n1 = nums[p];
        }
        else if (count == mid + 1) {
            n2 = nums[p];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {1};
        FindMedianSortedArrays arrays = new FindMedianSortedArrays();
        System.out.println(arrays.findMedianSortedArrays(nums1, nums2));
    }
}
