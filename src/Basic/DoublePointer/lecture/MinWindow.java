package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {

    public String minWindow(String s, String t) {
        Map<Character, Integer> needs = new HashMap<>();
        int needCnt = t.length();
        for (int i=0; i<t.length(); i++) {
            char c = t.charAt(i);
            if (needs.containsKey(c)) {
                needs.put(c, needs.get(c) + 1);
            }
            else needs.put(c, 1);
        }
        int l = 0;
        int r = -1;
        int len = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (needs.containsKey(c)) {
                needs.put(c, needs.get(c) - 1);
                if (needs.get(c) >= 0) needCnt --;
            }
            while (needCnt <= 0) {
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    l = left;
                    r = right;
                }
                if (needs.containsKey(s.charAt(left))) {
                    needs.put(s.charAt(left), needs.get(s.charAt(left)) + 1);
                    if (needs.get(s.charAt(left)) > 0) needCnt ++;
                }
                left ++;
            }
            right ++;
        }
        return s.substring(l, r+1);
    }

    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
        System.out.println(minWindow.minWindow("bba", "ab"));
    }
}
