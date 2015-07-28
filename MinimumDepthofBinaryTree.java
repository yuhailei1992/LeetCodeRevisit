
public class Solution {
    public int minDepth(TreeNode root) {
        // block the null branches.
        if (root == null) {
            return 0;
        }

        int ld = minDepth(root.left);
        int rd = minDepth(root.right);
        if (ld == 0 && rd == 0) {
            return 1;
        } else if (ld == 0) {
            return rd + 1;
        } else if (rd == 0) {
            return ld + 1;
        } else {
            return Math.min(ld, rd) + 1;
        }
    }
}

// Solution 2: concise, but essentially the same idea.
public int minDepth(TreeNode root) {
    if (root == null) return 0;
    int L = minDepth(root.left), R = minDepth(root.right);
    return 1 + (Math.min(L, R) > 0 ? Math.min(L, R) : Math.max(L, R));
}