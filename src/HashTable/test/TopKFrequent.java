package HashTable.test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }
            else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (Integer key : map.keySet()) {
            Point point = new Point(key, map.get(key));
            if (pq.size() == k && point.cnt > pq.peek().cnt) {
                pq.poll();
                pq.add(point);
            }
            else if (pq.size() < k) {
                pq.add(point);
            }
        }
        int[] res = new int[k];
        for (int i=0; i<k; i++) {
            res[i] = pq.poll().val;
        }
        return res;
    }
}

class Point implements Comparable<Point>{
    int cnt;
    int val;

    public Point(int val, int cnt) {
        this.val = val;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Point o) {
        return Integer.compare(this.cnt, o.cnt);
    }
}
