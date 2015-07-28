
public class Solution {
    private int total;
    public int sumNumbers(TreeNode root) {
        total = 0;
        helper(root, 0);
        return total;
    }
    
    private void helper(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            total += (sum * 10 + root.val);
            return;
        } else {
            sum = sum * 10 + root.val;
            helper(root.left, sum);
            helper(root.right, sum);
        }
    }
}