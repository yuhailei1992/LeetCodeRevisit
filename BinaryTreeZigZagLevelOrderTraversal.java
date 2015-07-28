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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode temp = null;
        while (!queue.isEmpty()) {
            int levelSum = queue.size();
            List<Integer> levelRes = new ArrayList<Integer>();
            for (int i = 0; i < levelSum; i++) {
                temp = queue.poll();
                levelRes.add(temp.val);
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            res.add(levelRes);
        }
        // reverse.
        for (int i = 1; i < res.size(); i += 2) {
            reverseList(res.get(i));
        }
        return res;
    }
    
    private void reverseList(List<Integer> list) {
        int temp = 0;
        for (int i = 0; i < list.size() / 2; i++) {
            temp = list.get(i);
            list.set(i, list.get(list.size() - i - 1));
            list.set(list.size() - i - 1, temp); 
        }
    }
}