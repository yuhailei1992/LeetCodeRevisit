// Solution 1: check if breakable, then try to break.

public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
    	List<String> res = new ArrayList<>();

        int len = s.length();

        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        if (isBreakable(s, wordDict)) {
            helper(s, 0, wordDict, res, new ArrayList<String>(), dp);
        }
        return res;
    }

    private void helper(String s, int i, Set<String> wordDict, List<String> res, List<String> trace, boolean[] dp) {
    	if (i == s.length()) {
    		res.add(generateSpacedString(trace));
    		return;
    	} else if (dp[i]) {
    		for (int j = i + 1; j <= s.length(); ++j) {
    			if (wordDict.contains(s.substring(i, j))) {
    				dp[j] = true;
    				trace.add(s.substring(i, j));
    				helper(s, j, wordDict, res, trace, dp);
    				trace.remove(trace.size() - 1);
    			}
    		}
    	}
    }

    private String generateSpacedString(List<String> trace) {
    	String res = "";
    	for (String part : trace) {
    		res += part;
    		res += " ";
    	}
    	return res.substring(0, res.length() - 1);
    }
    
    private boolean isBreakable(String s, Set<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 0; i < len; ++i) {
        	if (dp[i]) {
	        	for (int j = i + 1; j <= len; ++j) {
	        		if (!dp[j] && wordDict.contains(s.substring(i, j))) {
	        			dp[j] = true;
	        		}
	        	}
	        }
        }
        return dp[len];
    }
}

// Another solution, start from the tail, and do it backwards. 
// The key is: put an arraylist for any index. If the index doesn't contain valid path, just
// put an empty arraylist.

public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        Map<Integer, List<String>> hm = new HashMap<>();
        int len = s.length();
        hm.put(len, new ArrayList<>(Arrays.asList("")));
        for (int i = len - 1; i >= 0; --i) {
            List<String> trace = new ArrayList<>();
            for (int j = i + 1; j <= len; ++j) {
                if (wordDict.contains(s.substring(i, j))) {
                    for (String str : hm.get(j)) {
                        trace.add(s.substring(i, j) + (j == len ? "" : " ") + str); 
                    }
                }
            }
            hm.put(i, trace);
        }
        return hm.get(0);
    }
}


