package Advanced.Bisection;

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > nums[mid-1]) {
                left = mid;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        FindPeakElement peakElement = new FindPeakElement();
        System.out.println(peakElement.findPeakElement(new int[]{-2147483648}));
    }
}
