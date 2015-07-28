
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        // the general procedure is: 
        // given an array, return root of the generated BST.
        if (nums == null || nums.length == 0) {
            return null;
        }
        
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        
        int midPoint = nums.length / 2;
        int[] leftArray = Arrays.copyOfRange(nums, 0, midPoint);
        int[] rightArray = Arrays.copyOfRange(nums, midPoint + 1, nums.length);
        TreeNode root = new TreeNode(nums[midPoint]);
        root.left = sortedArrayToBST(leftArray);
        root.right = sortedArrayToBST(rightArray);
        return root;
    }
}
// an optimization is to pass arrays, leftindex and 
// rightindex to subroutines

