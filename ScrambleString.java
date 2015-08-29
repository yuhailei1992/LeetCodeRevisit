public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        if (s1.equals(s2)) {
            return true;
        }

        int len = s1.length();

        if (len == 1) {
            return s1.equals(s2);
        }

        // Quick check.
        if (!isPerm(s1, s2)) {
            return false;
        }

        for (int i = 1; i < len; ++i) {
            if ((isScramble(s1.substring(0, i), s2.substring(0, i))
                && isScramble(s1.substring(i, len), s2.substring(i, len)))
                || (isScramble(s1.substring(0, i), s2.substring(len - i))
                    && (isScramble(s1.substring(len - i) && s2.substring(0, i))))) {
                return true;
            }
        }
        return false;
    }

    private boolean isPerm(String s1, String s2) {
        int[] bitmap = new int[26];
        for (char c : s1.toCharArray()) {
            bitmap[(int)(c - 'a')]++;
        }
        for (char c : s2.toCharArray()) {
            bitmap[(int)(c - 'a')]--;
        }
        for (int i : bitmap) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}