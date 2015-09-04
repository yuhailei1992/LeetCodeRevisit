public class Solution {
    public int longestConsecutive(int[] nums) {
        // 1, add everything into a set.
    	Set<Integer> set = new HashSet<>();
    	for (int i : nums) {
    		set.add(i);
    	}
        // 2, for each number, walk through its neighbors.
    	int maxLen = 0;
    	for (int i : nums) {
    		int len = 1;
    		int left = i - 1;
    		while (set.contains(left)) {
    			++len;
    			set.remove(left);
    			--left;
    		}
    		int right = i + 1;
    		while (set.contains(right)) {
    			++len;
    			set.remove(right);
    			++right;
    		}
    		maxLen = Math.max(maxLen, len);
    	}
    	return maxLen;
    }
}

// Solution 2: use radix sort
// be careful of duplicate numbers.
public class Solution {
    public int longestConsecutive(int[] nums) {
        nums = radixSort(nums);
        int maxLen = 1, len = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i - 1]) { // jump over duplicates.
                continue;
            } else if (nums[i] == nums[i - 1] + 1) {
                ++len;
            } else {
                maxLen = Math.max(maxLen, len);
                len = 1; // don't initialize it to 0.
            }
        }
        return Math.max(maxLen, len);
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