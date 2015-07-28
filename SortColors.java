public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        // two pointers.
        int l = 0;
        int r = nums.length - 1;
        for (int m = l; l < r && m <= r; ) {
            switch (nums[m]) {
                case 0: // swap to left.
                    swap(nums, l, m);
                    l++;
                    m = Math.max(m, l);
                    break;
                case 1:
                    m++;
                    break;
                case 2:
                    swap(nums, m, r);
                    r--;
                    m = Math.min(m, r);
                    break;
                default:
                    break;
            }
        }
    }
    
    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}