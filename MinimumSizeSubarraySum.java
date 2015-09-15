public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        boolean found = false;
        int sum = 0, minLen = Integer.MAX_VALUE;
        for (int start = 0, end = 0; end < nums.length; ++end) {
            sum += nums[end];
            if (sum >= s) {
                found = true;
                // update start;
                while (sum - nums[start] >= s) {
                    sum -= nums[start++];
                }
                // record current length.
                minLen = Math.min(minLen, end - start);
            }
        }
        return found == true ? (minLen + 1) : 0;
    }
}

// Another solution: O(n); discussed in https://leetcode.com/discuss/42143/4ms-solution-and-nlogn-solution-with-detailed-explanations
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        int[] sums = new int[len];
        int sum = 0;
        for (int i = 0; i < len; ++i) {
            sum += nums[i];
            sums[i] = sum;
        }
        
        int minLen = Integer.MAX_VALUE;
        boolean found = false;
        // Then, for each number, find the first element that is greater or equal to sum - s.
        for (int i = 0; i < len; ++i) {
            if (sums[i] >= s) {
                int target = sums[i] - s;
                int prevIndex = findFirstGreaterOrEqual(sums, 0, i, target);
                if (prevIndex != -1) {
                    found = true;
                    minLen = Math.min(minLen, i - prevIndex);
                }
            }
        }
        return found ? (minLen + 1) : 0;
    }
    
    // Find first greater.
    private int findFirstGreaterOrEqual(int[] nums, int l, int h, int target) {
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] <= target) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return nums[l] > target ? l : -1;
    }
}