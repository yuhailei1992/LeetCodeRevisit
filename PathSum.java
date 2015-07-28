
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        // for leaf nodes.
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        int expected = sum - root.val;
        return hasPathSum(root.left, expected) || hasPathSum(root.right, expected);
    }
}

