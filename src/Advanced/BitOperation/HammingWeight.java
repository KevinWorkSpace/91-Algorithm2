package Advanced.BitOperation;

public class HammingWeight {

    public int hammingWeight(int n) {
        int cnt = 0;
        int h = 1;
        for (int i=0; i<32; i++) {
            if ((h & n) != 0) {
                cnt ++;
            }
            h = h << 1;
        }
        return cnt;
    }
}
