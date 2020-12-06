package Advanced.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.color == 0) {
                node.color = 1;
                if (node.right != null) stack.add(node.right);
                stack.add(node);
                if (node.left != null) stack.add(node.left);
            }
            else {
                list.add(node.val);
            }
        }
        return list;
    }
}
