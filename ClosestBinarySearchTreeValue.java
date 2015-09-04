/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Solution 1: inorder traversal, O(n).
public class Solution {
    public int closestValue(TreeNode root, double target) {
        int[] res = new int[2];
        res[0] = root.val;
        inorder(root, target, res);
        return res[0];
    }

    private void inorder(TreeNode node, double target, int[] res) {
        if (node != null) {
            inorder(node.left, target, res);
            if (Math.abs((double)res[0] - target) > Math.abs((double)node.val - target)) {
                res[0] = node.val;
            }
            inorder(node.right, target, res);
        }
    }
}

// Solution 2: binary search, O(logn) time.
public class Solution {
    public int closestValue(TreeNode root, double target) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        
        TreeNode child = null;
        if (target > (double)root.val) {
            child = root.right;
        } else {
            child = root.left;
        }
        
        if (null == child) {
            return root.val;
        } else {
            int childRes = closestValue(child, target);
            return Math.abs(root.val - target) > Math.abs(childRes - target) ? childRes : root.val;
        }
    }
}

// Solution 3: iterative.
public class Solution {
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        TreeNode node = root;
        while (node != null) {
            // Update closest.
            if (Math.abs(node.val - target) < Math.abs(closest - target)) {
                closest = node.val;
            }
            // Choose a way.
            if (target < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return closest;
    }
}