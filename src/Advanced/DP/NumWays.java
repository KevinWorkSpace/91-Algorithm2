package Advanced.DP;

public class NumWays {

    public int numWays(int n) {
        if (n == 0) return 1;
        if (n <= 2return n;
        int s1 = 1;
        int s2 = 2;
        int sum = 0;
        for (int i=3; i<=n; i++) {
            sum = (s1 + s2) % 1000000007;
            s1 = s2;
            s2 = sum;
        }
        return sum;
    }
}
