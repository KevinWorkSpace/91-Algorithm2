package Basic.DoublePointer.lecture;

import java.util.HashMap;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right != s.length()) {
            char c = s.charAt(right);
            if (!map.containsKey(c) || map.get(c) < left) {
                map.put(c, right);
                max = Math.max(max, right - left + 1);
            }
            else {
                left = map.get(c) + 1;
                map.put(c, right);
            }
            right ++;
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "";
        LengthOfLongestSubstring substring = new LengthOfLongestSubstring();
        System.out.println(substring.lengthOfLongestSubstring(s));
    }
}
