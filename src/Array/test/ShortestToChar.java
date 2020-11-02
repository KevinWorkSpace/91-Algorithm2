package Array.test;

import java.util.ArrayList;

public class ShortestToChar {

    public int[] shortestToChar(String S, char C) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<S.length(); i++) {
            if (S.charAt(i) == C) {
                list.add(i);
            }
        }
        int[] res = new int[S.length()];
        for (int i=0; i<res.length; i++) {
            if (S.charAt(i) == C) res[i] = 0;
            else {
                int min = Integer.MAX_VALUE;
                for (int j=0; j<list.size(); j++) {
                    if (Math.abs(list.get(j) - i) < min) {
                        min = Math.abs(list.get(j) - i);
                    }
                }
                res[i] = min;
            }
        }
        return res;
    }
}
