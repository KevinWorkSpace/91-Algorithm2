package Basic.Tree.lecture;

import java.util.Arrays;

public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        int max = 0;
        int maxIndex = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIndex));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIndex+1, nums.length));
        return root;
    }
}
