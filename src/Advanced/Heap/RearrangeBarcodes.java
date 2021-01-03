package Advanced.Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class RearrangeBarcodes {

    public int[] rearrangeBarcodes(int[] barcodes) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<barcodes.length; i++) {
            if (map.containsKey(barcodes[i])) {
                map.put(barcodes[i], map.get(barcodes[i]) + 1);
            }
            else map.put(barcodes[i], 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        for (int num : map.keySet()) {
            pq.add(num);
        }
        int n = barcodes.length;
        int[] res = new int[barcodes.length];
        int count = 0;
        for (int i=0; i<n/2; i++) {
            int n1 = pq.poll();
            int n2 = pq.poll();
            res[count++] = n1;
            res[count++] = n2;
            if (map.get(n1) > 1) {
                map.put(n1, map.get(n1) - 1);
                pq.add(n1);
            }
            if (map.get(n2) > 1) {
                map.put(n2, map.get(n2) - 1);
                pq.add(n2);
            }
        }
        if (!pq.isEmpty()) {
            res[count] = pq.poll();
        }
        return res;
    }
}
