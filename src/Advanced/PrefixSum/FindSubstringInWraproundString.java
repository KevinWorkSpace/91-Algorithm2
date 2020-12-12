package Advanced.PrefixSum;

import java.util.HashMap;
import java.util.HashSet;

public class FindSubstringInWraproundString {

    public int findSubstringInWraproundString(String p) {
        if (p.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(p.charAt(0), 1);
        int pre = 1;
        for (int i=1; i<p.length(); i++) {
            if (p.charAt(i) - p.charAt(i-1) == 1 || p.charAt(i) == 'a' && p.charAt(i-1) == 'z') {
                pre += 1;
            }
            else pre = 1;
            if (!map.containsKey(p.charAt(i)) || map.get(p.charAt(i)) < pre) {
                map.put(p.charAt(i), pre);
            }
        }
        int sum = 0;
        for (Character c : map.keySet()) {
            sum += map.get(c);
        }
        return sum;
    }

    public static void main(String[] args) {
        String p = "cac";
        FindSubstringInWraproundString substringInWraproundString = new FindSubstringInWraproundString();
        int res = substringInWraproundString.findSubstringInWraproundString(p);
        System.out.println(res);
    }
}
