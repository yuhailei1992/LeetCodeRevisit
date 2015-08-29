public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        
        int i = 0, j = height.length - 1, surface = 0, water = 0;
        while (i <= j) {
            surface = Math.max(surface, Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                water += Math.max(0, surface - height[i++]);
            } else {
                water += Math.max(0, surface - height[j--]);
            }
        }
        return water;
    }
}