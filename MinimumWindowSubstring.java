public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        // Sets up the 'valid' character positions.
        boolean[] filter = new boolean[256];
        int[] tarr = new int[256];
        int numDistinct = 0;
        for (char c : t.toCharArray()) {
            if (!filter[(int)c]) {
                numDistinct++;
            }
            filter[(int)c] = true;
            tarr[(int)c]--;
        }
        
        int minLen = Integer.MAX_VALUE, ms = 0, me = 0, numNeg = numDistinct;
        for (int start = 0, end = 0; end < s.length(); ++end) {
            char c = s.charAt(end);
            if (filter[(int)c]) {
                if (++tarr[(int)c] == 0) {
                    numNeg--;
                }
            }
            while (numNeg == 0) {
                if (end - start < minLen) {
                    minLen = end - start;
                    ms = start; me = end;
                }
                int toRem = s.charAt(start++);
                if (filter[(int)toRem]) {
                    if (--tarr[(int)toRem] == -1) {
                        numNeg++;
                    }
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(ms, me + 1);
    }
}