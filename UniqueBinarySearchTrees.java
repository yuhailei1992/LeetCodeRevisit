/**
 * Solution 1: recursive. TLE.
 * Solution 2:
 */
public class Solution {
    
    public int numTrees(int n) {
        if (n < 2) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int[] map = new int[n + 1];
        map[0] = 1;
        map[1] = 1;
        map[2] = 2;
        return numTreesHelper(n, map);
    }
    
    private int numTreesHelper(int n, int[] map) {
        if (map[n] != 0) {
            return map[n];
        } else {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += numTreesHelper(i, map) * numTreesHelper(n - 1 - i, map);
            }
            return sum;
        }
    }
}

// actually, it is absolutely ok to use iterative solution.
public class Solution {
    
    public int numTrees(int n) {
        if (n < 2) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int[] map = new int[n + 1];
        map[0] = 1;
        map[1] = 1;
        map[2] = 2;
        for (int i = 3; i <= n; i++) {
            // calculate map[i].
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += map[j] * map[i - 1 - j];
            }
            map[i] = sum;
        }
        return map[n];
    }
}