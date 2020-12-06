package Basic.Tree.lecture;

import java.util.Arrays;

class BuildTreePrePost {

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length == 0 || post.length == 0) return null;
        TreeNode root = new TreeNode(pre[0]);
        if (pre.length == 1) return root;
        for (int i=0; i<post.length; i++) {
            if (post[i] == pre[1]) {
                int[] leftPre = Arrays.copyOfRange(pre, 1, 1+i+1);
                int[] rightPre = Arrays.copyOfRange(pre, i+1+1, pre.length);
                int[] leftPost = Arrays.copyOfRange(post, 0, i+1);
                int[] rightPost = Arrays.copyOfRange(post, i+1, post.length-1);
                root.left = constructFromPrePost(leftPre, leftPost);
                root.right = constructFromPrePost(rightPre, rightPost);
                break;
            }
        }
        return root;
    }
}
