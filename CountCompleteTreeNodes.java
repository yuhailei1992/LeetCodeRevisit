// Solution 1: TLE. use a queue to do level-order traversal.
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int cnt = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode p = null;
        while (!queue.isEmpty()) {
            int currNum = queue.size();
            for (int i = 0; i < currNum; i++) {
                p = queue.poll();
                cnt++;
                if (p.left != null) {
                    queue.add(p.left);
                }
                if (p.right != null) {
                    queue.add(p.right);
                }
            }
        }
        return cnt;
    }
}

// Solution 2: make use of the problem's specification.
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int currHeight = getHeight(root);
        if (currHeight - 1 == getHeight(root.right)) {
            // meaning that the right part is not empty;
            return (1 << currHeight) + countNodes(root.right);
        } else {
            return (1 << (currHeight - 1)) + countNodes(root.left);
        }
    }
    
    private int getHeight(TreeNode node) {
        if (node == null) {
            return -1;
        } else {
            // optimized for this problem: because we know the nodes
            // in the last row are as left as possible.
            return 1 + getHeight(node.left);
        }
    }
}
