public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] arr = s.toCharArray();
        int len = arr.length;
        int[] dp = new int[len];
        dp[0] = arr[0] == '0' ? 0 : 1;
        for (int i = 1; i < len; i++) {
            // if the previous state is impossible, the current is impossible too.
            if (dp[i - 1] == 0) {
                return 0;
            }
            boolean isValidTwoDigit = isValid(s.substring(i - 1, i + 1));
            if (arr[i] == '0') { // must be with previous digit.
                dp[i] = isValidTwoDigit ? (i > 1 ? dp[i - 2] : 1) : 0;
            } else { // 
                dp[i] = isValidTwoDigit ? dp[i - 1] + (i > 1 ? dp[i - 2] : 1) : dp[i - 1];
            }
        }
        return dp[len - 1];
    }
    
    private boolean isValid(String s) {
        if (s.charAt(0) == '0') { // cannot start with 0.
            return false;
        }
        int val = Integer.parseInt(s);
        return val >= 1 && val <= 26;
    }
}

