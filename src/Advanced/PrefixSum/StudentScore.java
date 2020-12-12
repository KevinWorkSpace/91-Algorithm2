package Advanced.PrefixSum;

public class StudentScore {

    public int[] test(int[] scores, int[] mi) {
        int[] prefix = new int[150];
        for (int i=0; i<scores.length; i++) {
            prefix[scores[i]] += 1;
        }
        for (int i=1; i<prefix.length; i++) {
            prefix[i] += prefix[i-1];
        }
        int[] res = new int[mi.length];
        for (int i=0; i<mi.length; i++) {
            res[i] = prefix[scores[i]] / scores.length;
        }
        return res;
    }
}
