/**
 * How to prove this is the optimal solution?
 * 
 */
public class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, max = 0;

        while (l < r) {
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            if (height[l] <= height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return max;
    }
}