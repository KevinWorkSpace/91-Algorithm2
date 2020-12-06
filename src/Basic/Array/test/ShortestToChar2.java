package Basic.Array.test;

public class ShortestToChar2 {

    public int[] shortestToChar(String S, char C) {
        int[] res = new int[S.length()];
        int prev = Integer.MIN_VALUE / 2;
        for (int i=0; i<S.length(); i++) {
            if (S.charAt(i) == C) {
                prev = i;
            }
            else {
                res[i] = i - prev;
            }
        }
        prev = Integer.MAX_VALUE / 2;
        for (int i=S.length()-1; i>=0; i--) {
            if (S.charAt(i) == C) {
                prev = i;
            }
            else {
                res[i] = Math.min(res[i], prev - i);
            }
        }
        return res;
    }
}
