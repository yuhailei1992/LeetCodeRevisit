public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Solution 1: treat the 2D matrix as a 1D matrix, and use binary search.
        int l = 0;
        int M = matrix.length;
        int N = matrix[0].length;
        int LEN = M * N;
        int h = LEN - 1;
        
        int m = 0;
        while (l <= h) {
            m = l + (h - l) / 2;
            int mRow = m / N;
            int mCol = m % N;
            if (matrix[mRow][mCol] == target) {
                return true;
            } else if (matrix[mRow][mCol] > target) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
}

// Solution 2: use binary search, the first time search for the row, 
// the second time search within the row.

