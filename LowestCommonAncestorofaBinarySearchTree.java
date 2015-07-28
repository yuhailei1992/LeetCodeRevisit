
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        
        if (root == p || root == q) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l == null && r == null) {
            return null;
        } else if (l != null && r == null) {
            return l;
        } else if (r != null && l == null) {
            return r;
        } else {
            return root;
        }
    }
}

// using BST's properties, recursive.
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
         * consider the properties of BST: node.left.val < node.val < node.right.val.
         * so: if node.val > Math.max(p.val, q.val), the LCA should be at left;
         * if node.val < Math.min(p.val, q.val), the LCA should be at right;
         * if node.val == p.val || node.val == q.val, node is the LCA;
         */
         if (root.val < Math.min(p.val, q.val)) {
             return lowestCommonAncestor(root.right, p, q);
         }
         if (root.val > Math.max(p.val, q.val)) {
             return lowestCommonAncestor(root.left, p, q);
         }
         return root;
    }
}

// iterative solution.
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
         * consider the properties of BST: node.left.val < node.val < node.right.val.
         * so: if node.val > Math.max(p.val, q.val), the LCA should be at left;
         * if node.val < Math.min(p.val, q.val), the LCA should be at right;
         * if node.val == p.val || node.val == q.val, node is the LCA;
         */
         // iterative solution:
         int max = Math.max(p.val, q.val);
         int min = Math.min(p.val, q.val);
         TreeNode node = root;
         while (node.val > max || node.val < min) {
             if (node.val > max) {
                 node = node.left;
             } else {
                 node = node.right;
             }
         }
         return node;
    }
}