/**
 * Binary Tree inorder traversal, iterative.
 */
public class BSTIterator {

    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        // configure an initial stack.
        stack = new Stack<>();
        TreeNode p = root;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode toRet = stack.pop();
        TreeNode p = toRet.right;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
        return toRet.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */