// Only two possible situations: robbing first or robbing last.
public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // calculate the sum of robbing the first house. 
        int sum1 = rob2(nums, 0, nums.length - 1);
        // calculate the sum of not robbing the first house.
        int sum2 = rob2(nums, 1, nums.length);
        return Math.max(sum1, sum2);
    }
    
    private int rob2(int[] nums, int start, int end) {
        int rob = 0, notrob = 0;
        for (int i = start; i < end; ++i) {
            int currob = notrob + nums[i];
            notrob = Math.max(rob, notrob);
            rob = currob;
        }
        return Math.max(rob, notrob);
    }
}