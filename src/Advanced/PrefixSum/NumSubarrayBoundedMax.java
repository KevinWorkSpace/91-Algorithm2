package Advanced.PrefixSum;

public class NumSubarrayBoundedMax {

    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return atMost(A, R) - atMost(A, L-1);
    }

    public int atMost(int[] A, int x) {
        int pre = 0;
        int sum = 0;
        for (int i=0; i<A.length; i++) {
            if (A[i] <= x) {
                pre += 1;
            }
            else pre = 0;
            sum += pre;
        }
        return sum;
    }
}
