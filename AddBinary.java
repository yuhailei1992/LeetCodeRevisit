/** Add Binary
 *
 */

public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }

        int carry = 0;
        int tmpVal = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            tmpVal = carry + (i >= 0 ? (a.charAt(i) - '0') : 0) + (j >= 0 ? (b.charAt(j) - '0') : 0);
            sb.append(tmpVal % 2);
            carry = tmpVal / 2;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}