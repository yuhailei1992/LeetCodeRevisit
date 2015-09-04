public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null ||matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length, n = matrix[0].length;
        int maxLen = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == '1') {
                    dp[i+1][j+1] = Math.min(Math.min(dp[i][j+1], dp[i+1][j]), dp[i][j]) + 1;
                    maxLen = Math.max(maxLen, dp[i+1][j+1]);
                }
            }
        }
        return maxLen * maxLen;
    }
}