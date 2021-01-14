package Advanced.BitOperation;

public class ReverseBits {

    public int reverseBits(int n) {
        int h = 1;
        int res = 0;
        for (int i=0; i<32; i++) {
            int bit = 0;
            if ((n & h) != 0) {
                bit = 1;
            }
            else bit = 0;
            res ^= bit << (31 - i);
            h = h << 1;
        }
        return res;
    }

    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits();
        System.out.println(reverseBits.reverseBits(43261596));
    }
}
