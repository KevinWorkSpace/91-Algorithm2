package Advanced.Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class FrequencySort2 {

    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else {
                map.put(c, 1);
            }
        }
        for (char key : map.keySet()) {
            pq.add(key);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            for (int i=0; i<map.get(c); i++) {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}