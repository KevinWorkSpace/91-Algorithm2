package Basic.DoublePointer.lecture;

public class PeakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1};
        PeakIndexInMountainArray array = new PeakIndexInMountainArray();
        int res = array.peakIndexInMountainArray(arr);
        System.out.println(res);
    }
}
