package Advanced.BackTrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    public String[] permutation(String s) {
        char[] ar = s.toCharArray();
        Arrays.sort(ar);
        s = String.valueOf(ar);
        int n = s.length();
        List<String> list = new ArrayList<>();
        boolean[] used = new boolean[n];
        backTrace(list, s, new StringBuffer(), used);
        String[] res = new String[list.size()];
        for (int i=0; i<res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void backTrace(List<String> res, String s, StringBuffer path, boolean[] used) {
        if (path.length() == s.length()) {
            res.add(path.toString());
            return;
        }
        for (int i=0; i<s.length(); i++) {
            if (!used[i]) {
                if (i > 0 && s.charAt(i) == s.charAt(i-1) && !used[i-1]) continue;
                path.append(s.charAt(i));
                used[i] = true;
                backTrace(res, s, path, used);
                path = path.deleteCharAt(path.length()-1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String s = "aab";
        Permutation permutation = new Permutation();
        String[] strings = permutation.permutation(s);
        System.out.println(strings);
    }
}
