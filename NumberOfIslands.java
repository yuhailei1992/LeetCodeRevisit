/**
 * There are a bunch of solutions for this problem. 
 */
// Solution 1: dumb dfs.
public class Solution {
    public int numIslands(char[][] grid) {
        int sum = 0;
        while (hasIsland(grid)) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        sum++;
                        setZeroRec(grid, i, j);
                    }
                }
            }
        }
        return sum;
    }

    private boolean hasIsland(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    return true;
                }
            }
        }
        return false;
    }

    private void setZeroRec(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length
            || col < 0 || col >= grid[0].length
            || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        setZeroRec(grid, row+1, col);
        setZeroRec(grid, row-1, col);
        setZeroRec(grid, row, col+1);
        setZeroRec(grid, row, col-1);
    }
}

// Solution 2: slightly better dfs. Noticed that we don't need to check if
// there is island at all.
public class Solution {
    public int numIslands(char[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    sum++;
                    setZeroRec(grid, i, j);
                }
            }
        }
        return sum;
    }

    private void setZeroRec(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length
            || col < 0 || col >= grid[0].length
            || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        setZeroRec(grid, row+1, col);
        setZeroRec(grid, row-1, col);
        setZeroRec(grid, row, col+1);
        setZeroRec(grid, row, col-1);
    }
}

// Solution 3: even better. Use a DIRS array.
public class Solution {
    private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static final char L = '1', W = '0';
    
    public int numIslands(char[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == L) {
                    sum++;
                    sink(grid, i, j);
                }
            }
        }
        return sum;
    }
    
    private void sink(char[][] grid, int row, int col) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == L) {
            grid[row][col] = W;
            for (int[] dir : DIRS) {
                sink(grid, row + dir[0], col + dir[1]);
            }
        }
    }
}


