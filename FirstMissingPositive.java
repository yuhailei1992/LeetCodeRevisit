public class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
    		while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
    			// swap.
    			if (nums[i] != nums[nums[i] - 1]) {
    			    swap(nums, i, nums[i] - 1);
    			} else { // prevent from infinite loops.
    			    break;
    			}
    		}
        }
        // Find the missing positive.
        for (int i = 0; i < nums.length; ++i) {
        	if (nums[i] != i + 1) {
        		return i + 1;
        	}
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int m, int n) {
    	int tmp = nums[m];
    	nums[m] = nums[n];
    	nums[n] = tmp;
    }
}