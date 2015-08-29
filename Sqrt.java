/**
 * The reason why we use l = m + 1 and h = m - 1 is that we need to make sure that we
 * shrink the range. However, we can do it in another way: judge if l and h differ by
 * 1. If so, then we cannot further shrink the range by l = m because m == l.
 */

public class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        
        int l = 0, h = x;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (x / m == m || l == h - 1) {
                return m;
            } else if (x / m < m) {
                h = m;
            } else {
                l = m;
            }
        }
        return l;
    }
}

// Solution 2: use last_mid to record the most recent middle.
public class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        
        int l = 0, h = x, last_mid = 0;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (x / m == m) {
                return m;
            } else if (x / m < m) {
                h = m - 1;
            } else {
                l = m + 1;
                last_mid = m;
            }
        }
        return last_mid;
    }
}