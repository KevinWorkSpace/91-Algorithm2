package Basic.Tree.test;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftValue {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.right != null) {
                queue.add(node.right);
            }
            if (node.left != null) {
                queue.add(node.left);
            }
        }
        return node.val;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

