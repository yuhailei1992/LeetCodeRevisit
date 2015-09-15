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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // Corner case.
        if (root == null || root.left == null) {
        	return root;
        }
    	TreeNode prev = root, node = prev.left, next = null;
    	TreeNode prevright = prev.right;
        while (node != null) {
        	// Saves.
        	next = node.left;
        	node.left = prevright;
        	prevright = node.right;
        	node.right = prev;
        	// For next.
        	prev = node;
        	node = next;
        }
        root.left = null;
        root.right = null;
        return prev;
    }
}