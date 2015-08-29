public class Solution {
    private static final int NUM_CHAR = 256;
    
    public boolean canPermutePalindrome(String s) {
        if (s == null) {
            return false;
        } else if (s.length() < 2) {
            return true;
        }
        // Gets statistics of the characters in string.
        boolean[] occurrance = new boolean[NUM_CHAR];
        for (char c : s.toCharArray()) {
            occurrance[(int)c] = !occurrance[(int)c];
        }
        // Gets the number of single characters.
        int numTrue = 0;
        for (boolean b : occurrance) {
            if (b) {
                ++numTrue;
            }
        }
        // For odd and even length strings, different strategies.
        if (s.length() % 2 == 0) {
            return numTrue == 0;
        } else {
            return numTrue == 1;
        }
    }
}