public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        
        int i = 0, j = 0;
        for ( ; i < s.length() && j < t.length(); ++i, ++j) {
            if (s.charAt(i) != t.charAt(j)) {
                if (s.length() == t.length()) {
                    return s.substring(i + 1).equals(t.substring(j + 1));
                } else if (s.length() > t.length()) {
                    return s.substring(i + 1).equals(t.substring(j));
                } else {
                    return s.substring(i).equals(t.substring(j + 1));
                }
            }
        }
        return i != s.length() || j != t.length();
    }
}