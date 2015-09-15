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
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    private TreeNode helper(TreeNode node) {
        // Null or leaf node.
    	if (node == null || (node.left == null && node.right == null)) {
    		return node;
    	} else if (node.left == null) { // no left child: flatten right and return tail.
    		return helper(node.right);
    	} else if (node.right == null) { // no right child: use right as left and return tail.
    		node.right = node.left;
    		return helper(node.right);
    	} else { // has left and right child: node - l - r, return tail of r.
    		TreeNode l = node.left, r = node.right;
	    	node.right = l;
	    	helper(l).right = r;
	    	return helper(r);
    	}
    }
}

// Solution 2: O(nlogn):
public class Solution {
	public void flatten(TreeNode root) {
	    while (root != null) {
    		// let root.left.last point to root.right;
    		if (root.left != null && root.right != null) {
    			TreeNode p = root.left;
    			while (p.right != null) {
    				p = p.right;
    			}
    			p.right = root.right;
    		}
    
    		if (root.left != null) {
    			root.right = root.left;
    			root.left = null;
    		}
    		root = root.right;
	    }
	}
}

// Solution 3: preorder traversal: use pre to store the previous node.
public class Solution {
	public void flatten(TreeNode root) {
		helper(root, null);
	}
	
	private TreeNode helper(TreeNode root, TreeNode pre) {
	    if (root == null) {
	        return pre;
	    }
	    pre = helper(root.right, pre);
	    pre = helper(root.left, pre);
	    root.right = pre;
	    root.left = null;
	    return root;
	}
}

// Solution 4: straightforward.
public class Solution {
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}

		TreeNode left = root.left, right = root.right;
		root.left = null;
		flatten(left);
		flatten(right);
		TreeNode p = root;
		if (left != null) {
		    p.right = left;
			while (p.right != null) {
				p = p.right;
			}
		}
		p.right = right;
	}
}