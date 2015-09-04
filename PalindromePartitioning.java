// Backtracking solution.
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(res, s, new ArrayList<String>());
        return res;
    }

    private void helper(List<List<String>> res, String s, List<String> trace) {
    	if (s.length() == 0) {
    		res.add(new ArrayList<>(trace));
    	}
    	for (int i = 0; i < s.length(); ++i) {
    		if (isPalindrome(s, 0, i)) {
    			trace.add(s.substring(0, i + 1));
    			helper(res, s.substring(i + 1), trace);
    			trace.remove(trace.size() - 1);
    		}
    	}
    }

    private boolean isPalindrome(String s, int start, int end) {
    	if (start >= end) {
    		return true;
    	}
    	
    	for ( ; start < end; ++start, --end) {
    		if (s.charAt(start) != s.charAt(end)) {
    			return false;
    		}
    	}
    	return true;
    }
}

// DP Solution
