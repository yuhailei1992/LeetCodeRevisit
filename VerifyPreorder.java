public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> stk = new Stack<>();
        for (int i : preorder) {
        	if (i < low) {
        		return false;
        	}
        	while (!stk.isEmpty() && i > stk.peek()) {
        		low = stk.pop();
        	}
        	stk.push(i);
        }
        return true;
    }
}