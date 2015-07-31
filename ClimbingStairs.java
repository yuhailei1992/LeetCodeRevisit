/**
 * Classical DP problem. Simple and straightforward solution as follows:
 */

public class Solution {
    public int climbStairs(int n) {
        int[] tmp = new int[n + 1];
        tmp[0] = 1;
        tmp[1] = 1;
        for (int i = 2; i <= n; i++) {
            tmp[i] = tmp[i - 1] + tmp[i - 2];
        }
        return tmp[n];
    }
}

// A simple enhancement which uses constant space.
public class Solution {
    public int climbStairs(int n) {
        int a = 1, b = 1;
        for (int i = 2; i <= n; i++) {
            b = a + b;
            a = b - a;
        }
        return b;
    }
}
