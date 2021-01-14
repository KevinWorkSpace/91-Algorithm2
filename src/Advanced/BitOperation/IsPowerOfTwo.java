package Advanced.BitOperation;

import com.sun.org.apache.bcel.internal.generic.FADD;

public class IsPowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        int h = 1;
        int cnt = 0;
        for (int i=0; i<31; i++) {
            if ((n & h) != 0) {
                cnt ++;
                if (cnt > 1) {
                    return false;
                }
            }
            h = h << 1;
        }
        return (n & h) != 0;
    }
}
