package Basic.Tree.test;

import java.util.LinkedList;
import java.util.Queue;

public class SumNumbers2 {

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                node.left.val = node.val * 10 + node.left.val;
                queue.add(node.left);
            }
            if (node.right != null) {
                node.right.val = node.val * 10 + node.right.val;
                queue.add(node.right);
            }
            if (node.right == null && node.left == null) {
                sum += node.val;
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n9 = new TreeNode(9);
        n4.left = n9;
        n4.right = n0;
        n9.left = n5;
        n9.right = n1;
        SumNumbers2 sumNumbers = new SumNumbers2();
        sumNumbers.sumNumbers(n4);
    }
}
