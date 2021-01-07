package Basic.DoublePointer.lecture;

import java.util.HashSet;
import java.util.Set;

public class MaxVowels2 {

    static Set<Character> set = new HashSet<>();

    static {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
    }

    public int maxVowels(String s, int k) {
        int max = 0;
        for (int i=0; i<k; i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                max ++;
            }
        }
        int cnt = max;
        for (int i=k; i<s.length(); i++) {
            char c = s.charAt(i);
            char c2 = s.charAt(i-k);
            if (set.contains(c)) cnt ++;
            if (set.contains(c2)) cnt --;
            max = Math.max(max, cnt);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "a";
        int k = 1;
        MaxVowels2 maxVowels2 = new MaxVowels2();
        System.out.println(maxVowels2.maxVowels(s, k));
    }
}
