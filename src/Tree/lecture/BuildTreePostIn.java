package Tree.lecture;

import java.util.Arrays;

class BuildTreePostIn {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        for (int i=0; i<inorder.length; i++) {
            if (inorder[i] == postorder[postorder.length-1]) {
                int[] leftPost = Arrays.copyOfRange(postorder, 0, i);
                int[] rightPost = Arrays.copyOfRange(postorder, i, postorder.length-1);
                int[] leftIn = Arrays.copyOfRange(inorder, 0, i);
                int[] rightIn = Arrays.copyOfRange(inorder, i+1, inorder.length);
                root.left = buildTree(leftIn, leftPost);
                root.right = buildTree(rightIn, rightPost);
                break;
            }
        }
        return root;
    }
}
