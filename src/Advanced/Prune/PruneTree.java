package Advanced.Prune;

public class PruneTree {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        if (!containOne(root)) return null;
        if (root.left != null) {
            root.left = pruneTree(root.left);
        }
        if (root.right != null) {
            root.right = pruneTree(root.right);
        }
        return root;
    }

    public boolean containOne(TreeNode root) {
        boolean left = false;
        boolean right = false;
        if (root.left != null) {
            left = containOne(root.left);
        }
        if (root.right != null) {
            right = containOne(root.right);
        }
        if (root.left == null && root.right == null) {
            if (root.val == 1) return true;
            else return false;
        }
        if (!left && !right && root.val == 0) return false;
        else return true;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(0);
        TreeNode n3 = new TreeNode(0);
        TreeNode n4 = new TreeNode(1);
        n1.right = n2;
        n2.left = n3;
        n2.right = n4;
        PruneTree pruneTree = new PruneTree();
        pruneTree.pruneTree(n1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
