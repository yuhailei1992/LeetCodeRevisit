// Solution 1: fill the holes that are exposed to outer sides with 'Y'. Stackoverflow.
public class Solution {
	private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public void solve(char[][] board) {
        // 1, fill the holes which are exposed to boundaries with 'Y';
    	for (int i = 0; i < board.length; ++i) {
    		for (int j = 0; j < board[0].length; ++j) {
    			if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length) {
    				if (board[i][j] == 'O') {
    					fillHoles(board, i, j);
    				}
    			}
    		}
    	}
        // 2, fill 'O' with 'X', fill the 'Y' with 'O'.
    	for (int i = 0; i < board.length; ++i) {
    		for (int j = 0; j < board[0].length; ++j) {
    			if (board[i][j] == 'O') {
    				board[i][j] = 'X';
    			} else if (board[i][j] == 'Y') {
    				board[i][j] = 'O';
    			}
    		}
    	}
    }

    private void fillHoles(char[][] board, int i, int j) {
    	if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) { // out of bound.
    		return;
    	}
    	if (board[i][j] == 'O') {
    		board[i][j] = 'Y';
    		for (int[] dir : DIRS) {
    			fillHoles(board, i + dir[0], j + dir[1]);
    		}
    	}
    }

    private void fillHoles2(char[][] board, int i, int j) {
    	if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) { // out of bound.
    		return;
    	}
    	Queue<int[]> queue = new LinkedList<>();
    	queue.offer(new int[2]{i, j});
    	while (!queue.isEmpty()) {
    		int[] pos = queue.poll();
    		board[i][j] = 'Y';
    		for (int[] dirs : DIRS) {
    			if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] == 'O') {
    				queue.offer(new int[2]{i, j});
    			}
    		}
    	}
    }
}

// 2, BFS
public class Solution {
    private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public void solve(char[][] board) {
        if (board.length < 2 || board[0].length < 2) {
            return;
        }
        // 1, fill the holes which are exposed to boundaries with 'Y';
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < board.length; ++i) {
            if (board[i][0] == 'O') {
                int[] point = {i, 0};
                queue.add(point);
            }
            if (board[i][board[0].length - 1] == 'O') {
                int[] point = {i, board[0].length - 1};
                queue.add(point);
            }
        }
        
        for (int j = 0; j < board[0].length; ++j) {
            if (board[0][j] == 'O') {
                int[] point = {0, j};
                queue.add(point);
            }
            if (board[board.length - 1][j] == 'O') {
                int[] point = {board.length - 1, j};
                queue.add(point);
            }
        }
        fillHoles(queue, board);
        // 2, fill 'O' with 'X', fill the 'Y' with 'O'.
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void fillHoles(Queue<int[]> queue, char[][] board) {
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            board[pos[0]][pos[1]] = 'Y';
            for (int[] dir : DIRS) {
                int i2 = pos[0] + dir[0], j2 = pos[1] + dir[1];
                if (i2 >= 0 && i2 < board.length && j2 >= 0 && j2 < board[0].length && board[i2][j2] == 'O') {
                    int[] nextPoint = {i2, j2};
                    queue.offer(nextPoint);
                }
            }
        }
    }
}