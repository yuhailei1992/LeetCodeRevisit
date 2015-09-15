public class Solution {
	private static final char EMPTY = '.';

    public void solveSudoku(char[][] board) {
    	dfs(board);
    }

    private boolean dfs(char[][] board) {
    	for (int i = 0; i < board.length; ++i) {
    		for (int j = 0; j < board[0].length; ++j) {
    			if (board[i][j] == EMPTY) {
    				// Try different things.
        			for (char c = '1'; c <= '9'; ++c) {
        				if (isValid(board, c, i, j)) {
        					board[i][j] = c;
        					if (dfs(board)) {
        						return true;
        					} else {
        					    board[i][j] = EMPTY;
        					}
        				}
        			}
        			return false;
    			}
    		}
    	}
    	// No more empty slot. True, true.
    	return true;
    }

    private boolean isValid(char[][] board, char x, int r, int c) {
    	for (int i = 0; i < board.length; ++i) {
    		if (i != r && board[i][c] == x) {
    			return false;
    		}
    	}

    	for (int j = 0; j < board[0].length; ++j) {
    		if (j != c && board[r][j] == x) {
    			return false;
    		}
    	}

    	int m = r / 3, n = c / 3;
    	for (int i = m * 3; i < m * 3 + 3; ++i) {
    		for (int j = n * 3; j < n * 3 + 3; ++j) {
    			if (!(i == r && j == c) && board[i][j] == x) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
}

// Solution 2:

public class Solution {
	private static final char EMPTY = '.';
	private static final char START = '1';
	private static final char END = '9';

    public void solveSudoku(char[][] board) {
    	boolean[][] row = new boolean[9][9];
    	boolean[][] col = new boolean[9][9];
    	boolean[][] cell = new boolean[9][9];
    	for (int i = 0; i < board.length; ++i) {
    	    for (int j = 0; j < board[0].length; ++j) {
    	        if (board[i][j] != EMPTY) {
    	            int index = board[i][j] - START, cellIndex = i / 3 * 3 + j / 3;
    	            row[i][index] = true; col[j][index] = true; cell[cellIndex][index] = true;
    	        }
    	    }
    	}
    	dfs(board, row, col, cell);
    }

    private boolean dfs(char[][] board, boolean[][] row, boolean[][] col, boolean[][] cell) {
    	for (int i = 0; i < board.length; ++i) {
    		for (int j = 0; j < board[0].length; ++j) {
    			if (board[i][j] == EMPTY) {
        			for (char c = START; c <= END; ++c) {
        				int index = c - START, cellIndex = i / 3 * 3 + j / 3;
        				if ((row[i][index] || col[j][index] || cell[cellIndex][index]) == false) {
        					board[i][j] = c;
        					row[i][index] = true; col[j][index] = true; cell[cellIndex][index] = true;
        					if (dfs(board, row, col, cell)) {
        						return true;
        					} else {
        						row[i][index] = false; col[j][index] = false; cell[cellIndex][index] = false;
        					    board[i][j] = EMPTY;
        					}
        				}
        			}
        			return false;
    			}
    		}
    	}
    	// No more empty slot. True, true.
    	return true;
    }
}
