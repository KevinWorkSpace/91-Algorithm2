package Basic.Tree.lecture;

public class IsValidBST2 {

    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        else {
            pre = root.val;
            if (!isValidBST(root.right)) {
                return false;
            }
            return true;
       }
    }
}
