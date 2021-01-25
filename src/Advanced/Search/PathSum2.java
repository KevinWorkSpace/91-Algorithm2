package Advanced.Search;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (root == null) return res;
        backTrace(res, path, root, 0, targetSum);
        return res;
    }

    public void backTrace(List<List<Integer>> res, List<Integer> path, TreeNode node, int tmp, int targetSum) {
        if (node == null) return;
        path.add(node.val);
        tmp += node.val;
        if (targetSum == tmp && node.left == null && node.right == null) {
            res.add(new ArrayList<>(path));
        }
        backTrace(res, path, node.left, tmp, targetSum);
        backTrace(res, path, node.right, tmp, targetSum);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(-2);
        TreeNode n2 = new TreeNode(-3);
        n1.right = n2;
        PathSum2 sum = new PathSum2();
        sum.pathSum(n1, -5);
    }
}
