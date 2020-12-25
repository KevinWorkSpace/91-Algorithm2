package Advanced.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i=0; i<stones.length; i++) {
            pq.add(stones[i]);
        }
        while (pq.size() > 1) {
            int s1 = pq.poll();
            int s2 = pq.poll();
            if (s1 != s2) {
                pq.add(Math.abs(s1 - s2));
            }
        }
        if (pq.size() == 1) return pq.poll();
        else return 0;
    }

    public static void main(String[] args) {
        int[] stones = {1, 1};
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        System.out.println(lastStoneWeight.lastStoneWeight(stones));
    }
}
