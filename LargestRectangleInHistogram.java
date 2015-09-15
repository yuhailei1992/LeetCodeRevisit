public class Solution {    
    public int largestRectangleArea(int[] height) {
    	int len = height.length;
    	Stack<Integer> s = new Stack<>();
    	int maxArea = 0;
    	for (int i = 0; i <= len; ++i) {
    		int currHeight = i == len ? 0 : height[i];
    		if (s.isEmpty() || currHeight >= s.peek()) {
    			s.push(i);
    		} else {
    			int prev = s.pop();
    			maxArea = Math.max(maxArea, height[prev] * (s.isEmpty() ? i : i - 1 - s.peek()));
    			--i;
    		}
    	}
    	return maxArea;
    }
}
