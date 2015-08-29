public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 0; i < len; ++i) {
        	if (dp[i]) {
	        	for (int j = i + 1; j <= len; ++j) {
	        		// only set true when it is not true and can be jumped from previous state.
	        		if (!dp[j] && wordDict.contains(s.substring(i, j))) {
	        			dp[j] = true;
	        		}
	        	}
	        }
        }
        return dp[len];
    }
}