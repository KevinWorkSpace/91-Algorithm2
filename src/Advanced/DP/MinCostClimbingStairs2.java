package Advanced.DP;

public class MinCostClimbingStairs2 {

    public int minCostClimbingStairs(int[] cost) {
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i=2; i<=cost.length; i++) {
            c = Math.min(b + cost[i-1], a + cost[i-2]);
            a = b;
            b = c;
        }
        return c;
    }
}
