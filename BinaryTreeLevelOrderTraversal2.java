// use a depth variable, which decreases from maxdepth.
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // result container.
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        // get the depth first.
        int depth = maxDepth(root);
        // initialize container.
        for (int i = 0; i < depth; i++) {
            res.add(new ArrayList<Integer>());
        }
        // recursively traverse.
        traverse(root, res, depth - 1);
        return res;
    }
    
    private void traverse(TreeNode node, List<List<Integer>> res, int level) {
        if (node == null) {
            return;
        }
        res.get(level).add(node.val);
        traverse(node.left, res, level - 1);
        traverse(node.right, res, level - 1);
    }
    
    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
        }
    }
}