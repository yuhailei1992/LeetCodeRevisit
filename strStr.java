public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        
        int hl = haystack.length(), nl = needle.length();
        if (hl < nl) {
            return -1;
        } else if (nl == 0) {
            return 0;
        }
        
        for (int i = 0; i <= hl - nl; ++i) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (isSubStr(haystack, needle, i)) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    private boolean isSubStr(String haystack, String needle, int i) {
        for (int j = 0; j < needle.length(); ++j) {
            if (haystack.charAt(i + j) != needle.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}

// More elegant solution:
public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        
        for (int i = 0; ; ++i) {
            for (int j = 0; ; ++j) {
                if (j == needle.length()) {
                    return i;
                } else if (i + j == haystack.length()) {
                    return -1;
                }
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
        }
    }
}