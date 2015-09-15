// For each fence, we have two ways: paint it with the same color as prev, or different
// therefore, we need two dp arrays to store the intermediate results.
// dp1 stores the number of ways that current post is in different color from prev
// dp2 stores ... same
// we have: dp1[i] = dp2[i - 1] because they are same color and cannot be same with prev post
// dp2[i] = (dp1[i - 1] + dp2[i - 1]) * (k - 1)
// therefore, dp2[i] = (dp2[i - 1] + dp2[i - 2]) * (k - 1)
// this is similar to the fibonacci problem, and can be solved with O(n) time, O(1) space.

public class Solution {
    public int numWays(int n, int k) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return k;
        } else if (n == 2) {
            return k * k;
        } else {
            // use dp.
            int a = k, b = k * (k - 1);
            for (int i = 2; i < n; ++i) {
                int tmp = (a + b) * (k - 1);
                a = b;
                b = tmp;
            }
            return a + b;
        }
    }
}