public class Solution {
    public int minCut(String s) {
    	if (s.length() < 2) {
    		return 0;
    	}

        int len = s.length();
        boolean[][] palindrome = new boolean[len][len];
        // Sets the cut numbers to maximum.
        int[] cut = new int[len];
        for (int i = 0; i < cut.length; ++i) {
            cut[i] = i;
        }
        // Updates the cut numbers.
        for (int r = 1; r < len; ++r) {
            cut[r] = Math.min(cut[r], cut[r - 1] + 1); // For corner cases like "dde".
            // Why go backwards? To achieve the min num of cuts.
        	for (int l = r - 1; l >= 0; --l) {
        		if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || palindrome[l + 1][r - 1])) {
        			palindrome[l][r] = true;
        			cut[r] = Math.min(cut[r], l == 0 ? 0 : (cut[l - 1] + 1));
        		}
        	}
        }
        return cut[len - 1];
    }
}