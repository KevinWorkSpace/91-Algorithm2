package Advanced.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallest {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i=0; i<matrix.length; i++) {
            pq.add(new int[]{matrix[i][0], i, 0});
        }
        int count = 0;
        int[] tmp = null;
        while (count < k) {
            tmp = pq.poll();
            count ++;
            int row = tmp[1];
            int col = tmp[2];
            if (col < n - 1) {
                pq.add(new int[]{matrix[row][col+1], row, col+1});
            }
        }
        return tmp[0];
    }
}
