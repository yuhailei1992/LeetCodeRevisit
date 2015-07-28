// Solution 1 is complex and error-prone.
public class Solution {
    int maxDepth;
    private TreeNode deepestTreeNode;
    private Map<TreeNode, Boolean> hm1;
    private Map<TreeNode, Boolean> hm2;
    private Map<TreeNode, Map<TreeNode, Boolean>> nodeMap;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        maxDepth = -1;
        deepestTreeNode = null;
        hm1 = new HashMap<TreeNode, Boolean>();
        hm2 = new HashMap<TreeNode, Boolean>();
        nodeMap = new HashMap<TreeNode, Map<TreeNode, Boolean>>();
        nodeMap.put(p, hm1);
        nodeMap.put(q, hm2);

        hasDescendent1(root, p, q, 0);
        return deepestTreeNode;
    }

    private boolean hasDescendent1(TreeNode node, TreeNode des1, TreeNode des2, int depth) {
        if (hasDescendent(node, des1) && hasDescendent(node, des2)) {
            if (depth > maxDepth) {
                maxDepth = depth;
                deepestTreeNode = node;
            }
            hasDescendent1(node.left, des1, des2, depth + 1);
            hasDescendent1(node.right, des1, des2, depth + 1);
            return true;
        } else {
            return false;
        }
    }

    private boolean hasDescendent(TreeNode node, TreeNode des) {
        if (node == null) {
            return false;
        }
        // try to get it from hashmap.
        if (nodeMap.containsKey(des) 
            && nodeMap.get(des).containsKey(node)) {
            return nodeMap.get(des).get(node);
        }
        // not contained in hashmap. do the check and put in hashmap.
        if (node == des || hasDescendent(node.left, des) || hasDescendent(node.right, des)) {
            nodeMap.get(des).put(node, true);
            return true;
        } else {
            nodeMap.get(des).put(node, false);
            return false;
        }
    }
}

// Solution 2: recursive.

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        
        // if this node is p or q, then return true.
        if (root == p || root == q) {
            return root;
        }
        
        // then check left child and right child.
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l == null && r == null) {
            return null;
        } else if (l == null) {
            return r;
        } else if (r == null) {
            return l;
        } else {
            return root; // it is impossible that root.left and root.right are ancestors at the same time.
        }
    }
}

// Solution 3: iterative.
