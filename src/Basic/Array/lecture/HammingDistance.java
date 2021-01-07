package Basic.Array.lecture;

public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int cnt = 0;
        for (int i=31; i>=0; i--) {
            int lastX = x % 2;
            int lastY = y % 2;
            if (lastX != lastY) cnt++;
            x = x >> 1;
            y = y >> 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        HammingDistance distance = new HammingDistance();
        System.out.println(distance.hammingDistance(1, 4));
    }
}
