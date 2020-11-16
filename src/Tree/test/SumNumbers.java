package Leetcode;

import org.omg.CORBA.INTERNAL;

public class SumNumbers {

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int i) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return i * 10 + root.val;
        }
        int tmp = i * 10 + root.val;
        return helper(root.left, tmp) + helper(root.right, tmp);
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
        SumNumbers sumNumbers = new SumNumbers();
        sumNumbers.sumNumbers(n4);
    }
}
