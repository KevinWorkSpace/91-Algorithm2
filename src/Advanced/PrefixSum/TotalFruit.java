package Advanced.PrefixSum;

import java.util.HashMap;

public class TotalFruit {

    private HashMap<Integer, Integer> map = new HashMap<>();

    public int totalFruit(int[] tree) {
        return atMost(2, tree);
    }

    public int atMost(int k, int[] tree) {
        int i = 0;
        int ans = 0;
        for (int j=0; j<tree.length; j++) {
            if (!map.containsKey(tree[j]) || map.get(tree[j]) == 0) {
                k --;
                map.put(tree[j], 1);
            }
            else {
                map.put(tree[j], map.get(tree[j]) + 1);
            }
            while (k < 0) {
                map.put(tree[i], map.get(tree[i]) - 1);
                if (map.get(tree[i]) == 0) k ++;
                i ++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3,3,3,1,2,1,1,2,3,3,4};
        TotalFruit totalFruit = new TotalFruit();
        int res = totalFruit.totalFruit(nums);
        System.out.println(res);
    }
}
