package Basic.Tree.lecture.BalanceTree;

public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length);
    }

    public TreeNode dfs(int[] nums, int left, int right) {
        if (left >= right) return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = dfs(nums, left, mid);
        node.right = dfs(nums, mid+1, right);
        return node;
    }
}
