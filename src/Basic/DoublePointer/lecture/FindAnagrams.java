package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        int[] needs = new int[26];
        int[] windows = new int[26];
        for (int i=0; i<p.length(); i++) {
            char c = p.charAt(i);
            needs[c - 'a'] += 1;
        }
        int left = 0;
        int right = 0;
        List<Integer> list = new ArrayList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            windows[c - 'a'] ++;
            while (windows[c - 'a'] > needs[c - 'a']) {
                char tmp = s.charAt(left);
                windows[tmp - 'a'] --;
                left ++;
            }
            if (right - left + 1 == p.length()) {
                list.add(left);
            }
            right ++;
        }
        return list;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        FindAnagrams findAnagrams = new FindAnagrams();
        findAnagrams.findAnagrams(s, p);
    }
}
