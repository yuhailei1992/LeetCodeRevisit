public class Solution {
    public String convert(String s, int numRows) {
        // if numRows is 1, step is 0.
        if (numRows == 1) {
            return s;
        }
        char[] strarr = s.toCharArray();
        int len = s.length();
        int step = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < len; j += step) {
                sb.append(strarr[j]);
                if (i > 0 && i < numRows - 1) {
                    if (j + step - 2 * i < len) {
                        sb.append(strarr[j + step - 2 * i]);
                    }
                }
            }
        }
        return sb.toString();
    }
}