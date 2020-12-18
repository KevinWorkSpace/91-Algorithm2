package Advanced.BackTrace;

import java.util.ArrayList;
import java.util.List;

public class Combine {

    private int k;
    private int n;

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        this.k = k;
        this.n = n;
        backTrace(1, lists, path);
        return lists;
    }

    public void backTrace(int start, List<List<Integer>> lists, List<Integer> path) {
        if (path.size() == k) {
            lists.add(new ArrayList<>(path));
            return;
        }
        for (int i=start; i<=n - (k - path.size()) + 1; i++) {
            path.add(i);
//            System.out.println("before " + path);
            backTrace(i+1, lists, path);
//            System.out.println("after " + path);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        Combine solution = new Combine();
        int n = 5;
        int k = 3;
        List<List<Integer>> res = solution.combine(n, k);
        System.out.println(res);
    }
}
