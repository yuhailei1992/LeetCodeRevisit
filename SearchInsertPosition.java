public class Solution {
    public int searchInsert(int[] nums, int target) {
        // Handles the edge case that target is larger than any of the nums and therefore
        // should be inserted in the end.
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        
        int l = 0, r = nums.length - 1;
        while (l < r) {
        	int m = l + (r - l) / 2;
        	if (nums[m] == target) {
        		return m;
        	} else if (nums[m] > target) {
        		r = m;
        	} else {
        		l = m + 1;
        	}
        }
        return l;
    }
}

// A cleaner solution: change the loop invariant to l <= r, which allows l to be greater than r
// when it exits loop and thus can reach nums.length.
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                r = m - 1; // Note the difference between this and previous solution.
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}

// In the second solution, r = m - 1. If not, it is possible that l == 0 and r == 0 and the loop
// doesn't end.