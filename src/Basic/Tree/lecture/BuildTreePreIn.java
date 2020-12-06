package Basic.Tree.lecture;

class BuildTreePreIn {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode helper(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
        if (ir < il || pl > preorder.length-1 || pr > preorder.length-1 || il > inorder.length-1 || ir > inorder.length-1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pl]);
        if (pl == pr || il == ir) return root;
        int index = 0;
        for (int i=il; i<=ir; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        int leftNum = index - il;
        root.left = helper(preorder, pl+1, pl+leftNum, inorder, il, index-1);
        root.right = helper(preorder, pl+leftNum+1, pr, inorder, index+1, ir);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    int color;
    TreeNode(int x) { val = x; }
}

