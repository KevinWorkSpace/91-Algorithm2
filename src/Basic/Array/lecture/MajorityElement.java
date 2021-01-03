package Basic.Array.lecture;

import java.util.Arrays;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count ++;
            }
            else {
                if (candidate == nums[i]) {
                    count ++;
                }
                else {
                    count --;
                }
            }
        }
        return candidate;
    }

}
