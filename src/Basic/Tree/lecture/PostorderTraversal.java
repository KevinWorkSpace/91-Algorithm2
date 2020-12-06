package Basic.Tree.lecture;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.color == 0) {
                node.color = 1;
                stack.add(node);
             if (node.right != null) stack.add(node.right);
                if (node.left != null) stack.add(node.left);
            }
            else list.add(node.val);
        }
        return list;
    }
}
