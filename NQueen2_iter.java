public class Solution {
    public class Solution {
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        
        // if the current level is nth level, increment counter[0]; if not, try all the positions and
        // go back to a shallower level.
        // if we are at level one and cannot find a solution, break.
        int[] pos = new int[n];
        boolean[] col = new boolean[n];
        boolean[] rmc = new boolean[2 * n + 1];
        boolean[] rpc = new boolean[2 * n + 1];

        int i = 0, j = 0, counter = 0;
        while (true) {
            // Checks the sanity of i - j.
            if (j == n) { // j already reaches end.
                if (i == 0) { // i cannot fall back anymore.
                    break; // backtracking ends.
                } else { // i can fall back, go back to prev level.
                    if (--i < 0) {
                        break;
                    }
                    // deletes the existence of previous i - j.
                    j = pos[i];
                    delete(col, rmc, rpc, i, j);
                    // let j start from next value.
                    j++;
                }
            } else if (valid(col, rmc, rpc, i, j)) {
                if (i == n - 1) {
                    counter++;
                    // then fall back.
                    if (--i < 0) {
                        break;
                    }
                    // deletes the existence of previous i - j.
                    j = pos[i];
                    delete(col, rmc, rpc, i, j);
                    // let j start from next value.
                    j++;
                } else { // valid, and not yet the last level.
                    pos[i] = j;
                    add(col, rmc, rpc, i, j);
                    i++;
                    // j starts from 0.
                    j = 0;
                }
            } else { // not valid, try another j.
                j++;
            }
        }
        return counter;
    }

    // Checks if the i - j pair is valid.
    private boolean valid(boolean[] col, boolean[] rmc, boolean[] rpc, int r, int c) {
        int imj = r - c + col.length - 1, ipj = r + c;
        return !(col[c] || rmc[imj] || rpc[ipj]);
    }

    // Adds the existence of i and j on chess board.
    private void add(boolean[] col, boolean[] rmc, boolean[] rpc, int r, int c) {
        int imj = r - c + col.length - 1, ipj = r + c;
        col[c] = true;
        rmc[imj] = true;
        rpc[ipj] = true;
    }

    // Removes the existence of i and j on chess board.
    private void delete(boolean[] col, boolean[] rmc, boolean[] rpc, int r, int c) {
        int imj = r - c + col.length - 1, ipj = r + c;
        col[c] = false;
        rmc[imj] = false;
        rpc[ipj] = false;
    }
}
}