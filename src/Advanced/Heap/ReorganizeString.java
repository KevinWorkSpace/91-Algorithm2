package Advanced.Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ReorganizeString {

    public String reorganizeString(String S) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            }
            else {
                map.put(c, map.get(c) + 1);
            }
        }
        int n = S.length();
        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        for (char c : map.keySet()) {
            if (map.get(c) > (n + 1) / 2) {
                return "";
            }
            pq.add(c);
        }
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<n/2; i++) {
            char c1 = pq.poll();
            char c2 = pq.poll();
            builder.append(c1);
            builder.append(c2);
            if (map.get(c1) > 1) {
                map.put(c1, map.get(c1) - 1);
                pq.add(c1);
            }
            if (map.get(c2) > 1) {
                map.put(c2, map.get(c2) - 1);
                pq.add(c2);
            }
        }
        if (!pq.isEmpty()) {
            builder.append(pq.poll());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        ReorganizeString reorganizeString = new ReorganizeString();
        System.out.println(reorganizeString.reorganizeString("aab"));
    }
}
