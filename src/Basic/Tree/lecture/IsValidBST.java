package Basic.Tree.lecture;

public class IsValidBST {

    long tmp = Long.MIN_VALUE;
    boolean flag = true;

    public boolean isValidBST(TreeNode root) {
        TreeNode node = root;
        InOrder(root);
        return flag;
    }

    public void InOrder(TreeNode root) {
        if (root.left != null) {
            InOrder(root.left);
        }
        if (root.val > tmp) {
            tmp = root.val;
        }
        else {
            flag = false;
            return;
        }
        if (root.right != null) {
            InOrder(root.right);
        }
    }
}
