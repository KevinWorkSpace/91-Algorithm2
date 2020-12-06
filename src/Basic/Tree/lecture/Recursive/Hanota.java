package Basic.Tree.lecture.Recursive;

import java.util.ArrayList;
import java.util.List;

public class Hanota {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        helper(A.size(), A, B, C);
    }

    public void helper(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) {
            C.add(A.remove(A.size()-1));
            return;
        }
        helper(n-1, A, C, B);
        C.add(A.remove(A.size()-1));
        helper(n-1, B, A, C);
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(1);
        A.add(0);
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        Hanota hanota = new Hanota();
        hanota.hanota(A, B, C);
    }

}
