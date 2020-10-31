package Array;

import java.util.HashMap;

public class SortColors {

    public void sortColors(int[] nums) {
        int p1 = 0;
        int p2 = nums.length - 1;
        int i = 0;
        while (i <= p2){
            if (nums[i] == 0) {
                swap(nums, p1, i);
                p1 ++;
                i++;
            }
            else if (nums[i] == 2) {
                swap(nums, p2, i);
                p2 --;
            }
            else i++;
        }
    }

    public void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
