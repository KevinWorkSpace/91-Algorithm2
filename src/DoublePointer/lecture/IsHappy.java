package DoublePointer.lecture;

public class IsHappy {

    public boolean isHappy(int n) {
        int slow = n;
        int fast = squareNum(n);
        while (slow != fast) {
            slow = squareNum(slow);
            fast = squareNum(squareNum(fast));
        }
        return slow == 1;
    }

    public int squareNum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        IsHappy isHappy = new IsHappy();
        boolean res = isHappy.isHappy(7);
        System.out.println(res);
    }
}
