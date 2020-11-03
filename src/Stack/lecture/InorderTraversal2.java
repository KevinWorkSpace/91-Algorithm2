package Stack.lecture;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal2 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null) {
                    stack.add(node.right);
                }
                stack.add(node);
                stack.add(null);
                if (node.left != null) {
                    stack.add(node.left);
                }
            }
            else {
                list.add(stack.pop().val);
            }
        }
        return list;
    }
}
