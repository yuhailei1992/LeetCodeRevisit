// Recursive: TLE
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return true;
        } else if (s.length() == 0) {
            return p.length() == 0 || allStar(p);
        } else if (p.length() == 0) {
            return s.length() == 0;
        }
        
        int slen = s.length(), plen = p.length();
        boolean[][] map = new boolean[slen + 1][plen + 1];
        // return helper(s, 0, p, 0, map);
        
        if (p.charAt(0) == '?') {
            return isMatch(s.substring(1), p.substring(1));
        } else if (p.charAt(0) != '*') {
            return s.charAt(0) == p.charAt(0) && isMatch(s.substring(1), p.substring(1));
        } else { // '*'
            for (int i = 1; i <= s.length(); ++i) {
                if (isMatch(s.substring(i), p.substring(1))) {
                    return true;
                }
            }
            return false;
        }
    }
    
    private boolean allStar(String s) {
        for (char c : s.toCharArray()) {
            if (c != '*') {
                return false;
            }
        }
        return true;
    }
}

// Memorization: TLE
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return true;
        } else if (s.length() == 0) {
            return p.length() == 0 || allStar(p);
        } else if (p.length() == 0) {
            return s.length() == 0;
        }
        
        int slen = s.length(), plen = p.length();
        boolean[][] map = new boolean[slen + 1][plen + 1];
        return helper(s, 0, p, 0, map);
    }
    
    private boolean helper(String s, int i, String p, int j, boolean[][] map) {
        if (map[i][j]) {
            return true;
        }
        if (i == s.length()) {
            return j == p.length();
        } else if (j == p.length()) {
            return i == s.length();
        }
        
        if (p.charAt(j) == '?') {
            if (helper(s, i + 1, p, j + 1, map)) {
                map[i][j] = true;
                return true;
            } else {
                return false;
            }
        } else if (p.charAt(j) != '*') {
            if (s.charAt(i) == p.charAt(j) && helper(s, i + 1, p, j + 1, map)) {
                map[i][j] = true;
                return true;
            } else {
                return false;
            }
        } else {
            for (int start = i + 1; start <= s.length(); ++start) {
                if (helper(s, start, p, j + 1, map)) {
                    map[start][j] = true;
                    return true;
                }
            }
            return false;
        }
    }
    
    private boolean allStar(String s) {
        for (char c : s.toCharArray()) {
            if (c != '*') {
                return false;
            }
        }
        return true;
    }

}

// DP:
public class Solution {
    public boolean isMatch(String s, String p) {
        int slen = s.length(), plen = p.length();
        if (plen == 0) {
            return slen == 0;
        }
        boolean[][] dp = new boolean[slen + 1][plen + 1];
        dp[0][0] = true;
        // Consecutive * can match to empty string. e.g. "" - "******"
        for (int j = 0; j < plen; ++j) {
            if (p.charAt(j) == '*') {
                dp[0][j + 1] = true;
            } else {
                break;
            }
        }
        // A * can match the whole string. e.g. "abc" - "*"
        if (p.charAt(0) == '*') {
            for (int i = 0; i <= slen; ++i) {
                dp[i][0] = true;
            }
        }
        // j is in outer loop because of "" with "*"
        for (int i = 0; i < slen; ++i) {
            for (int j = 0; j < plen; ++j) {
                if (p.charAt(j) == '*') {
                    dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j];
                } else if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
            }
        }

        return dp[slen][plen];
    }
}

// DP, 1d
public class Solution {
    public boolean isMatch(String s, String p) {
        int slen = s.length(), plen = p.length();
        if (plen == 0) {
            return slen == 0;
        }
        boolean[] prev = new boolean[plen + 1];
        prev[0] = true;
        // Consecutive * can match to empty string. e.g. "" - "******"
        for (int j = 0; j < plen; ++j) {
            if (p.charAt(j) == '*') {
                prev[j + 1] = true;
            } else {
                break;
            }
        }
        // j is in outer loop because of "" with "*"
        for (int i = 0; i < slen; ++i) {
            boolean[] curr = new boolean[plen + 1];
            for (int j = 0; j < plen; ++j) {
                if (p.charAt(j) == '*') {
                    curr[j + 1] = prev[j + 1] || (j == 0 ? true : curr[j]);
                } else if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
                    curr[j + 1] = prev[j];
                }
            }
            prev = curr;
        }

        return prev[plen];
    }
}

