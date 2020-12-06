package Basic.Array.test;

public class PlusOne2 {

    public int[] plusOne(int[] digits) {
        for (int i=digits.length-1; i>=0; i--) {
            digits[i]++;
            if (digits[i] % 10 == 0) {
                digits[i] = 0;
            }
            else return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
