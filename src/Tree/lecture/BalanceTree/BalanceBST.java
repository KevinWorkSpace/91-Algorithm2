package Tree.lecture.BalanceTree;

import java.util.ArrayList;

public class BalanceBST {

    ArrayList<Integer> list = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return helper(0, list.size());
    }

    public TreeNode helper(int left, int right) {
        if (left >= right) return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = helper(left, mid);
        node.right = helper(mid+1, right);
        return node;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
