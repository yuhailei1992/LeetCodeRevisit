public class Solution {
    public double myPow(double x, int n) {
    	if (n == 1) {
    		return x;
    	} else if (n == -1) {
    		return 1.0 / x;
    	} else if (n == 0) {
    		return 1.0;
    	}
    	// General cases.
    	double subPow = myPow(x, n / 2);
        if (n % 2 == 0) {
        	return subPow * subPow;
        } else {
        	if (n > 0) {
        		return subPow * subPow * x;
        	} else {
        		return subPow * subPow / x;
        	}
        }
    }
}