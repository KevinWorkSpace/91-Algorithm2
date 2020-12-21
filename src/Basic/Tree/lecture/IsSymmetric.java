package Basic.Tree.lecture;

public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return symmetric(root.left, root.right);
    }

    public boolean symmetric(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 != null && n2 == null || n1 == null && n2 != null) return false;
        if (n1.val != n2.val) return false;
        return symmetric(n1.left, n2.right) && symmetric(n1.right, n2.left);
    }
}
