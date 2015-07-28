/**
 * Solution 1: use a queue.
 * Solution 2: use DFS.
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        TreeNode p = null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> levelRes = new ArrayList<Integer>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                p = queue.poll();
                levelRes.add(p.val);
                if (p.left != null) {
                    queue.add(p.left);
                }
                if (p.right != null) {
                    queue.add(p.right);
                }
            }
            res.add(levelRes);
        }
        return res;
    }
}

// Solution 2: recursive. 
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        traverse(root, res, 0);
        return res;
    }
    
    private void traverse(TreeNode node, List<List<Integer>> res, int level) {
        if (node == null) {
            return;
        }
        
        if (res.size() < level + 1) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(node.val);
        traverse(node.left, res, level + 1);
        traverse(node.right, res, level + 1);
    }
}