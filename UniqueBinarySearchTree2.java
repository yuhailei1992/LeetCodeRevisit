
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<Integer> nums = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        return generateTreesHelper(nums);
    }
    
    private List<TreeNode> generateTreesHelper(List<Integer> nums) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (nums.size() == 0) {
            res.add(null);
            return res;
        }
        for (int i = 0; i < nums.size(); i++) {
            // for each num, regard it as the root, concatenate it with
            // the tree generated from sublists.
            List<Integer> leftSublist = nums.subList(0, i);
            List<Integer> rightSublist = nums.subList(i + 1, nums.size());
            int rootNum = nums.get(i);
            
            for (TreeNode l : generateTreesHelper(leftSublist)) {
                for (TreeNode r : generateTreesHelper(rightSublist)) {
                    TreeNode root = new TreeNode(rootNum);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}