/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        int[] counter = new int[2];
        isUnivalueTree(root, counter);
        return counter[0];
    }
    
    private boolean isUnivalueTree(TreeNode root, int[] counter) {
        if (root == null) { // null, true, but don't increment counter.
            return true;
        } else if (root.left == null && root.right == null) { // leaf, true, increment counter.
            counter[0]++;
            return true;
        }
        boolean isLeftUnivalueTree = isUnivalueTree(root.left, counter);
        boolean isRightUnivalueTree = isUnivalueTree(root.right, counter);
        if (isLeftUnivalueTree
            && isRightUnivalueTree
            && (root.left == null || root.val == root.left.val)
            && (root.right == null || root.val == root.right.val)) {
            counter[0]++;
            return true;
        } else {
            return false;
        }
    }
}