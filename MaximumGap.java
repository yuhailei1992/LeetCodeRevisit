public class Solution {
    public int maximumGap(int[] nums) {
        if (null == nums || nums.length < 2) {
            return 0;
        }
        // Sort the array with Radix Sort.
        nums = radixSort(nums);
        // Find the max gap.
        int maxGap = 0;
        for (int i = 1; i < nums.length; ++i) {
            maxGap = Math.max(maxGap, nums[i] - nums[i-1]);
        }
        return maxGap;
    }
    
    private int[] radixSort(int[] nums) {
        int len = nums.length;
        for (int shift = Integer.SIZE - 1; shift >= 0; --shift) {
            int[] tmp = new int[len];
            int j = 0;
            for (int i = 0; i < len; ++i) {
                // Decide to move or not.
                boolean move = nums[i] << shift >= 0;
                if (shift == 0) {
                    move = !move;
                }
                if (move) {
                    tmp[j] = nums[i];
                    j++;
                } else {
                    nums[i - j] = nums[i];
                }
            }
            // Merge two arrays.
            for (int i = j; i < len; ++i) {
                tmp[i] = nums[i - j];
            }
            nums = tmp;
        }
        return nums;
    }
}