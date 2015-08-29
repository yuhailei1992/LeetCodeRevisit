public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (s.length() == 0) {
            return p.length() == 0 || (p.length() >= 2 && p.charAt(1) == '*' && isMatch(s, p.substring(2)));
        }
        // Now we can safely assume that s and p are not null nor empty.
        if (p.length() == 1) {
            return s.length() == 1 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0));
        } else { // p.length() >= 2.
            if (p.charAt(1) != '*') {
                return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
            } else {
                int i = 0;
                for ( ;i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.'); ++i) {
                    if (isMatch(s.substring(i), p.substring(2))) {
                        return true;
                    }
                }
                return isMatch(s.substring(i), p.substring(2));
            }
        }
    }
}

// Solution 2: use DP.
