package Advanced.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.color == 0) {
                node.color = 1;
                if (node.right != null) stack.add(node.right);
                if (node.left != null) stack.add(node.left);
                stack.add(node);
            }
            else {
                list.add(node.val);
            }
        }
        return list;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    int color;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
