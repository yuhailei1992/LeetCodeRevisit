public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int zeros = 0;

        int range = n - m + 1;
        for (int shift = 0; shift < Integer.SIZE; ++shift) {
        	int x = 1 << shift;
        	if (range > x) { // range greater than the max univalue length.
        		zeros |= x;
        	} else { // range less than or equal to the max univalue length, need further check.
        		int start = m / x;
        		int end = n / x;
        		if (start < end) {
        			zeros |= x;
        		}
        	}
        }
        return (~zeros) & m;
    }
}