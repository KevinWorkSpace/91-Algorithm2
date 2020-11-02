package Array.test;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int plus = 1;
        for (int i=digits.length-1; i>=0; i--) {
            int num = digits[i] + plus;
            if (num == 10) {
                digits[i] = 0;
                plus = 1;
            }
            else {
                digits[i] = num;
                plus = 0;
            }
        }
        if (plus == 1) {
            digits = new int[digits.length+1];
            digits[0] = 1;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] a = {9, 9};
        PlusOne plusOne = new PlusOne();
        int[] res = plusOne.plusOne(a);
        System.out.println(res);
    }
}
