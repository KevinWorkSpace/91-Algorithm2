package Advanced.Prune;

public class PruneTree2 {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        if (root.left != null) {
            root.left = pruneTree(root.left);
        }
        if (root.right != null) {
            root.right = pruneTree(root.right);
        }
        if (root.left == null && root.right == null) {
            if (root.val == 1) return root;
            else return null;
        }
        return root;
    }
}