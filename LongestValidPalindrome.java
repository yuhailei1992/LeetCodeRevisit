public class Solution {
    public int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<>();

		int currLen = 0, maxLen = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.push(currLen);
				currLen = 0;
			} else {
				if (stack.isEmpty()) {
					currLen = 0;
				} else {
					currLen = currLen + stack.pop() + 2;
					maxLen = Math.max(maxLen, currLen);
				}
			}
		}
		return maxLen;
    }
}