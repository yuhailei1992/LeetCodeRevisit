public class Solution {
    public int jump(int[] nums) {
    	int n = nums.length, reach = nums[0];
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 0; i < n; ++i) {
        	reach = Math.max(reach, i + nums[i]);
        	for (int j = i + 1; j <= i + nums[i]; ++j) {
        		dp[j] = Math.min(dp[i] + 1, dp[j]);
        	}
        }
        return dp[n - 1];
    }
}