public class Solution {
    public int numSquares(int n) {
        // Square stores if a number is square.
        boolean[] square = new boolean[n + 1];
        // Dp stores the minimum number of 'cut'.
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            dp[i] = i;
        }
        // r start from 1 to n, l from r - 1 to 0.
        for (int r = 1; r <= n; ++r) {
            for (int l = r - 1; l >= 0; --l) {
                int diff = r - l;
                if (isSquare(square, diff)) {
                    dp[r] = Math.min(dp[r], l == 0 ? 1 : dp[l] + 1);
                }
            }
        }
        return dp[n];
    }
    
    private boolean isSquare(boolean[] square, int n) {
        if (square[n]) {
            return true;
        } else {
            int root = (int)(Math.sqrt(n));
            if (n == (root * root)) {
                square[n] = true;
            }
            return square[n];
        }
    }
}

