package Basic.Array.lecture;

public class HammingDistance2 {

    public int hammingDistance(int x, int y) {
        int cnt = 0;
        int sum = x ^ y;
        for (int i=31; i>=0; i--) {
            if (sum % 2 == 1) {
                cnt ++;
            }
            sum = sum >> 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        HammingDistance2 distance = new HammingDistance2();
        System.out.println(distance.hammingDistance(1, 4));
    }
}
