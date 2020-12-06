package Basic.HashTable.test;

import java.util.HashMap;

public class LengthOfLongestSubString {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 1;
        while (right != s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c) && left <= map.get(c)) {
                left = map.get(c) + 1;
            }
            map.put(c, right);
            res = Math.max(right - left + 1, res);
            right ++;
        }
        return res;
    }

    public static void main(String[] args) {
//        String s = "abba";
//        String s = "au";
        String s = "pwwkew";
        LengthOfLongestSubString subString = new LengthOfLongestSubString();
        int res = subString.lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
