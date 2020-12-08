package Advanced.DP;

public class ClimbStairs {

    public int climbStairs(int n) {
        if (n == 1 || n == 2) return n;
        int[] res = new int[n+1];
        res[1] = 1;
        res[2] = 2;
        for (int i=3; i<res.length; i++) {
            res[i] = res[i-1] + res[i-2];
        }
        return res[n];
    }

    public static void main(String[] args) {
        int n = 2;
        ClimbStairs climbStairs = new ClimbStairs();
        int res = climbStairs.climbStairs(3);
        System.out.println(res);
    }
}
