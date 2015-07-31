// the simplest solution uses O(mn) extra space.

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] tmp = new int[m + 1][n + 1];
        for (int i = 0; i < m; ++i) {
            tmp[i + 1][0] = 0;
        }
        for (int j = 0; j < n; ++j) {
            tmp[0][j + 1] = 0;
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 && j == 0) {
                    tmp[i + 1][j + 1] = 1;
                } else {
                    tmp[i + 1][j + 1] =
                        obstacleGrid[i][j] == 1 ? 0 : (tmp[i][j + 1] + tmp[i + 1][j]);
                }
            }
        }
        return tmp[m][n];
    }
}

// an improvement: modify the original obstacleGrid. Use negative path sum.
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        obstacleGrid[0][0] = -1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                obstacleGrid[i][0] = 0;
            } else {
                obstacleGrid[i][0] = obstacleGrid[i - 1][0] == 0 ? 0 : -1;
            }
        }
        
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                obstacleGrid[0][j] = 0;
            } else {
                obstacleGrid[0][j] = obstacleGrid[0][j - 1] == 0 ? 0 : -1;
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }
        return -obstacleGrid[m - 1][n - 1];
    }
}

// another improvement: use O(n) space instead of O(mn);
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // fail fast.
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int n = obstacleGrid[0].length;
        int[] tmp = new int[n];
        tmp[0] = 1;
        // the first row. can only come from left.
        for (int j = 1; j < n; ++j) {
            tmp[j] = obstacleGrid[0][j] == 1 ? 0 : tmp[j - 1];
        }
        // other rows. can come from top or left.
        for (int i = 1; i < obstacleGrid.length; ++i) {
            for (int j = 0; j < n; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    tmp[j] = 0;
                } else if (j != 0) {
                    tmp[j] = tmp[j - 1] + tmp[j];
                }
            }
        }
        return tmp[n - 1];
    }
}
// cleanup of O(n) solution:
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;
        int[] tmp = new int[n];
        tmp[0] = 1;
        // other rows. can come from top or left.
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < n; ++j) {
                if (row[j] == 1) {
                    tmp[j] = 0;
                } else if (j != 0) {
                    tmp[j] += tmp[j - 1];
                }
            }
        }
        return tmp[n - 1];
    }
}
