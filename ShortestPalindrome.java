public class Solution {
    public String shortestPalindrome(String s) {
        if (s.length() < 2) {
            return "";
        }
        
        int len = s.length();
        for (int j = s.length() - 1; j >= 0; --j) {
            if (isPalindrome(s, 0, j)) {
                return new StringBuilder(s.substring(j + 1)).reverse().toString();
            }
        }
        return "";
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        if (start == end) {
            return true;
        }
        for (; start < end; ++start, --end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
        }
        return true;
    }
}