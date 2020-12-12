package Advanced.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class FindTheLongestSubstring {

    public int findTheLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 0);
        map.put('i', 0);
        map.put('o', 0);
        map.put('u', 0);
        int pre = 0;
        int ans = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                if (map.get(c) % 2 != 0) {
                    map.put('a', 0);
                    map.put('e', 0);
                    map.put('i', 0);
                    map.put('o', 0);
                    map.put('u', 0);
                    map.put(c, 1);
                    ans = Math.max(ans, pre);
                    pre = 0;
                }
                else pre ++;
            }
            else {
                pre ++;
            }
        }
        return ans;
    }
}
