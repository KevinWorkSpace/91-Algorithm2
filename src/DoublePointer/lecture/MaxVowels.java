package DoublePointer.lecture;

import java.util.HashSet;

public class MaxVowels {

    public int maxVowels(String s, int k) {
        int cnt = 0;
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        for (int i=0; i<k; i++) {
            if (set.contains(s.charAt(i))) {
                cnt ++;
            }
        }
        int max = cnt;
        for (int i=1; i<=s.length()-k; i++) {
            if (set.contains(s.charAt(i-1))) {
                cnt --;
            }
            if (set.contains(s.charAt(i+k-1))) {
                cnt ++;
            }
            if (cnt > max) {
                max = cnt;
            }
        }
        return max;
    }
}
