public class Solution {
    public int totalNQueens(int n) {
        int[] counter = new int[1];
        if (n <= 0) {
            return counter[0];
        }
        // Records if a certain col or slope has been taken place.
        boolean[] col = new boolean[n];
        boolean[] rmc = new boolean[2 * n + 1];
        boolean[] rpc = new boolean[2 * n + 1];
        dfs(counter, 0, n, col, rmc, rpc);
        return counter[0];
    }

    private void dfs(int[] counter, int i, int n, boolean[] col, boolean[] rmc, boolean[] rpc) {
        if (i == n) {
            counter[0]++;
        } else {
            // Tries different things in layer level.
            for (int j = 0; j < n; ++j) {
                int imj = i - j + n - 1, ipj = i + j;
                if (col[j] || rmc[imj] || rpc[ipj]) {
                    continue;
                }
                col[j] = true; rmc[imj] = true; rpc[ipj] = true;
                dfs(counter, i + 1, n, col, rmc, rpc);
                col[j] = false; rmc[imj] = false; rpc[ipj] = false;
            }
        }
    }
}