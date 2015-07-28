public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        StringBuilder fixed = new StringBuilder();
        helper(0, 2 * n, fixed, res);
        return res;
    }
    
    private void helper(int left, int n, StringBuilder fixed, List<String> res) {
        if (fixed.length() + 1 == n) { // must end with ')'.
            if (left == 1) {
                fixed.append(')');
                res.add(new String(fixed));
                fixed.deleteCharAt(fixed.length() - 1);
            }
        }
        // can add a left parenthesis.
        if (left < n - fixed.length()) {
            fixed.append('(');
            helper(left + 1, n, fixed, res);
            fixed.deleteCharAt(fixed.length() - 1);
        }
        // or add a right parenthesis.
        if (left > 0) {
            fixed.append(')');
            helper(left - 1, n, fixed, res);
            fixed.deleteCharAt(fixed.length() - 1);
        }
    }
}