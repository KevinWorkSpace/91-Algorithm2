package Basic.Tree.lecture;

import java.util.Arrays;

public class BstFromPreOrder {

    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(inorder);
        return buildTree(preorder, inorder);
    }

    public TreeNode buildTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) return null;
        TreeNode root = new TreeNode(pre[0]);
        for (int i=0; i<in.length; i++) {
            if (in[i] == pre[0]) {
                int[] leftPre = Arrays.copyOfRange(pre, 1, 1+i);
                int[] rightPre = Arrays.copyOfRange(pre, i+1, pre.length);
                int[] leftIn = Arrays.copyOfRange(in, 0, i);
                int[] rightIn = Arrays.copyOfRange(in, i+1, in.length);
                root.left = buildTree(leftPre, leftIn);
                root.right = buildTree(rightPre, rightIn);
                break;
            }
        }
        return root;
    }
}
