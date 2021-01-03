package Advanced.Bisection;

public class MySqrt {

    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        while (left < right) {
            long mid = left + (right - left + 1) / 2;
            long m = mid * mid;
            if (m > x) {
                right = (mid - 1);
            }
            else {
                left = mid;
            }
        }
        return (int) left;
    }

    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(mySqrt.mySqrt(2147483647));
    }
}
