package Advanced.Greedy;

import java.util.Arrays;

public class FindContentChildren {

    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        int res = 0;
        for (int i=0; i<g.length; i++) {
            while (s[j] < g[i]) {
                j ++;
                if (j == s.length) break;
            }
            if (j == s.length) return res;
            j ++;
            res ++;
            if (j == s.length) return res;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] g = {10,9,8,7};
        int[] s = {5,6,7,8};
        FindContentChildren findContentChildren = new FindContentChildren();
        findContentChildren.findContentChildren(g, s);
    }
}
