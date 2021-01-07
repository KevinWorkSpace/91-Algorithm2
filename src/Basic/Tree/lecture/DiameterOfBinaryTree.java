package Basic.Tree.lecture;

public class DiameterOfBinaryTree {

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }

    public int depth(TreeNode root) {
        if (root == null) return 0;
        int L = depth(root.left);
        int R = depth(root.right);
        diameter = Math.max(diameter, L + R);
        return Math.max(L, R) + 1;
    }
}
