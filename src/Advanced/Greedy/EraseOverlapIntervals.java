package Advanced.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int right = intervals[0][1];
        int ans = 1;
        for (int i=1; i<intervals.length; i++) {
            if (intervals[i][0] >= right) {
                ans ++;
                right = intervals[i][1];
            }
        }
        return intervals.length - ans;
    }
}
