public class Solution {
    public boolean canJump(int[] nums) {
    	if (nums == null || nums.length == 0) {
    		return false;
    	}

        int reach = nums[0];
        for (int i = 1; i < nums.length && i <= reach; ++i) {
        	reach = Math.max(nums[i] + i, reach);
        }
        return reach >= nums.length - 1;
    }
}

// Solution 2: backwards.
public class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int last = len - 1;
        for (int i = len - 2; i >= 0; --i) {
            if (i + nums[i] >= last) {
                last = i;
            }
        }
        return last <= 0;
    }
}