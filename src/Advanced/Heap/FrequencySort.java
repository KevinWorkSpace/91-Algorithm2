package Advanced.Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class FrequencySort {

    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Element> pq = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o2.num - o1.num;
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
            Element e = new Element(c, map.get(c));
            pq.add(e);
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (!pq.isEmpty()) {
            Element e = pq.poll();
            if (map.get(e.c) == e.num) {
                for (int i=0; i<e.num; i++) {
                    stringBuffer.append(e.c);
                }
            }
        }
        return stringBuffer.toString();
    }
}

class Element {
    char c;
    int num;

    public Element(char c, int num) {
        this.c = c;
        this.num = num;
    }
}
