package Tree.lecture;

import java.util.LinkedList;
import java.util.Queue;

public class WidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        root.val = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int leftVal = 0;
            int rightVal = 0;
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) leftVal = node.val;
                if (i == size-1) rightVal = node.val;
                if (node.left != null) {
                    queue.add(node.left);
                    node.left.val = node.val * 2 + 1;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    node.right.val = node.val * 2 + 2;
                }
            }
            int width = rightVal - leftVal + 1;
            if (width > max) max = width;
        }
        return max;
    }
}
