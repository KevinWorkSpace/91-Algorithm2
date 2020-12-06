package Basic.Tree.lecture;

import java.util.*;

public class InorderTraversal {

    HashSet<TreeNode> set = new HashSet<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (!set.contains(node)) {
                set.add(node);
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
        InorderTraversal traversal = new InorderTraversal();
        traversal.inorderTraversal(n1);
    }

}
