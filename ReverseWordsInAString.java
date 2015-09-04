public class Solution {
    public void reverseWords(char[] s) {
        // 1, reverse the entire string.
        reverse(s, 0, s.length - 1);
        // 2, reverse each word, separated by space.
        int start = 0;
        for (int i = 0; i < s.length; ++i) {
            if (s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
        // 3, clean up for corner cases.
        reverse(s, start, s.length - 1);
    }
    
    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            ++start;
            --end;
        }
    }
}