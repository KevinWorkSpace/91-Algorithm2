package Tree.lecture;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class InorderTraversal2 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.color == 0) {
                node.color = 1;
                if (node.right != null) stack.add(node.right);
                stack.add(node);
                if (node.left != null) stack.add(node.left);
            }
            else list.add(node.val);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.right = n2;
        n2.left = n3;
        InorderTraversal2 traversal = new InorderTraversal2();
        traversal.inorderTraversal(n1);
    }

}
