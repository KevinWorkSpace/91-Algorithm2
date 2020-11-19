package Tree.lecture;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class WidthOfBinaryTree2 {

    HashMap<Integer, Integer> map = new HashMap<>();
    int ans = 0;

    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 0, 0);
        return ans;
    }

    public void dfs(TreeNode root, int depth, int pos) {
        if (root == null) return;
        if (!map.containsKey(depth)) map.put(depth, pos);
        ans = Math.max(ans, pos - map.get(depth) + 1);
        dfs(root.left, depth+1, pos * 2 + 1);
        dfs(root.right, depth+1, pos * 2 + 2);
    }
}
