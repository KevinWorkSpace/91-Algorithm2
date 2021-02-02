package Advanced.BitOperation;

public class CountBits2 {

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        for (int i=0; i<=num; i++) {
            if ((i & 1) == 0) {
                res[i] = res[i / 2];
            }
            else {
                res[i] = res[i - 1] + 1;
            }
        }
        return res;
    }
}
