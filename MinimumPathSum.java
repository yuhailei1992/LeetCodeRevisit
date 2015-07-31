public class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid[0].length;
        int[] t = new int[n];
        t[0] = grid[0][0];
        for (int j = 1; j < n; ++j) {
            t[j] = grid[0][j] + t[j - 1];
        }
        
        for (int i = 1; i < grid.length; ++i) {
            t[0] += grid[i][0];
            for (int j = 1; j < n; ++j) {
                t[j] = grid[i][j] + Math.min(t[j], t[j - 1]);
            }
        }
        return t[n - 1];
    }
}

