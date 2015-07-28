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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        // initial config: push left.
        Stack<TreeNode> stk = new Stack<>();
        TreeNode p = root;
        while (p != null) {
            stk.push(p);
            p = p.left;
        }
        while (!stk.isEmpty()) {
            p = stk.pop();
            res.add(p.val);
            if (p.right != null) {
                p = p.right;
                while (p != null) {
                    stk.push(p);
                    p = p.left;
                }
            }
        }
        return res;
    }
}

// Solution 2: recursive.
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorderHelper(root, res);
        return res;
    }

    private void inorderHelper(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inorderHelper(node.left, res);
        res.add(node.val);
        inorderHelper(node.right, res);
    }
}