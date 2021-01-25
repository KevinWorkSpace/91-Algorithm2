package Advanced.Search;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (root == null) return res;
        path.add(root.val);
        backTrace(res, path, root, root.val, targetSum);
        return res;
    }

    public void backTrace(List<List<Integer>> res, List<Integer> path, TreeNode node, int tmp, int targetSum) {
        if (targetSum == tmp && node.left == null && node.right == null) {
            res.add(new ArrayList<>(path));
        }
        if (node == null) return;
        if (node.left != null) {
            path.add(node.left.val);
            tmp += node.left.val;
            backTrace(res, path, node.left, tmp, targetSum);
            path.remove(path.size() - 1);
            tmp -= node.left.val;
        }
        if (node.right != null) {
            path.add(node.right.val);
            tmp += node.right.val;
            backTrace(res, path, node.right, tmp, targetSum);
            path.remove(path.size() - 1);
            tmp -= node.right.val;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(-2);
        TreeNode n2 = new TreeNode(-3);
        n1.right = n2;
        PathSum sum = new PathSum();
        sum.pathSum(n1, -5);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
