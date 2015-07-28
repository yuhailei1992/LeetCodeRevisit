public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean rowZero = false;
        boolean colZero = false;
        int M = matrix.length;
        int N = matrix[0].length;
        // record colZero.
        for (int i = 0; i < M; i++) {
            if (matrix[i][0] == 0) {
                colZero = true;
                break;
            }
        }
        // record rowZero.
        for (int j = 0; j < N; j++) {
            if (matrix[0][j] == 0) {
                rowZero = true;
                break;
            }
        }
        // record zeros.
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        // clear cols other than the first col.
        for (int j = 1; j < N; j++) {
            if (matrix[0][j] == 0) {
                clearCol(matrix, j);
            }
        }
        // clear rows other than the first row.
        for (int i = 1; i < M; i++) {
            if (matrix[i][0] == 0) {
                clearRow(matrix, i);
            }
        }
        // restore first row.
        if (rowZero) {
            clearRow(matrix, 0);
        }
        // restore first col.
        if (colZero) {
            clearCol(matrix, 0);
        }
    }
    
    private void clearRow(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }
    
    private void clearCol(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
}

// Solution 1 is pretty verbose. A concise solution is as follows:
