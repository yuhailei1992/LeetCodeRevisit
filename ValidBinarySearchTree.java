/**
 * Solution 1: recursively check.
 * Solution 2: inorder traversal, check if the values are ascending.
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // the initial value for min and max are defined as null.
        return isValidBSTHelper(root.left, null, root.val)
               && isValidBSTHelper(root.right, root.val, null);
    }

    private boolean isValidBSTHelper(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }
        return isValidBSTHelper(root.left, min, root.val)
               && isValidBSTHelper(root.right, root.val, max);
    }
}

// Solution 2:

public class Solution {
    private Integer currValue = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stk = new Stack<>();
        TreeNode p = root;
        while (p != null) {
            stk.push(p);
            p = p.left;
        }
        while (!stk.isEmpty()) {
            p = stk.pop();
            // check if the value is bigger.
            if (currValue == null) {
                currValue = p.val;
            } else {
                if (currValue >= p.val) {
                    return false;
                } else {
                    currValue = p.val;
                }
            }
            if (p.right != null) {
                p = p.right;
                while (p != null) {
                    stk.push(p);
                    p = p.left;
                }
            }
        }
        return true;
    }
}