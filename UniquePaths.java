public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] map = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            map[i][0] = 0;
        }
        for (int j = 0; j < n; j++) {
            map[0][j] = 0;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    map[1][1] = 1;
                } else {
                    map[i+1][j+1] = map[i][j+1] + map[i+1][j];
                }
            }
        }
        return map[m][n];
    }
}

// it is actually a math problem: combination numbers.
// see https://leetcode.com/discuss/18160/simple-c-version-using-math
public class Solution {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        long res = 1;
        for (int i = n; i < m + n - 1; i++) {
            res = res * i / (i - n + 1);
        }
        return (int)res;
    }
}