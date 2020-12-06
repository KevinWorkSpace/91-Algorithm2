package Leetcode;

public class MaxSatisfied {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int prev = 0;
        for (int i=0; i<X; i++) {
            prev += customers[i];
        }
        for (int i=X; i<customers.length; i++) {
            if (grumpy[i] == 0) {
                prev += customers[i];
            }
        }
        int max = prev;
        for (int j=1; j<=customers.length-X; j++) {
            int cnt = prev;
            if (grumpy[j-1] == 1) {
                cnt -= customers[j-1];
            }
            if (grumpy[j+X-1] == 1) {
                cnt += customers[j+X-1];
            }
            prev = cnt;
            max = Math.max(max, cnt);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] customers = {1};
        int[] grumpy = {0};
        MaxSatisfied maxSatisfied = new MaxSatisfied();
        int res = maxSatisfied.maxSatisfied(customers, grumpy, 1);
    }
}
