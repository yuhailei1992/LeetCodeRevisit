public class Solution {
    public int[] searchRange(int[] nums, int target) {
        // use binary search, find the left most one, and right most one.
        int[] res = new int[2];
        if (!isExist(nums, target)) {
            Arrays.fill(res, -1);
            return res;
        } else {
            double target1 = (double)target - 0.5;
            int l = binSearch(nums, target1);
            while (l < nums.length && nums[l] != target) {
                ++l;
            }
            res[0] = l;
            double target2 = (double)target + 0.5;
            int r = binSearch(nums, target2);
            r--; // r is likely to be out of bound.
            while (r >= 0 && nums[r] != target) {
                --r;
            }
            res[1] = r;
            return res;
        }
    }
    
    private boolean isExist(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return true;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }

    private int binSearch(int[] nums, double target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}

// Solution 2: cleaner
