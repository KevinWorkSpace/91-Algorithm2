package Leetcode;

public class New21Game {

    public double new21Game(int N, int K, int W) {
        double[] dp = new double[K+W];
        double s = 0;
        for (int i=K; i<dp.length; i++) {
            if (i > N) dp[i] = 0;
            else dp[i] = 1;
            s += dp[i];
        }
        for (int i=K-1; i>=0; i--) {
            dp[i] = s / W;
            s = s - dp[i+W] + dp[i];
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int N = 6;
        int K = 1;
        int W = 10;
        New21Game new21Game = new New21Game();
        System.out.println(new21Game.new21Game(N, K, W));
    }
}
