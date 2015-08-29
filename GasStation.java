// When you encounter circular things, think about 2n.
// Why result = i + 1? Suppose there is a valid start which is between previous result and
// current result, so that prev_res < start < curr_res, it is absolute that the sum over
// start ~ curr_res is positive, and the sum should have been negative before start, which is
// contradictory.

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int result = 0, sum = 0, n = gas.length;
        for (int i = 0; i < n * 2 - 1; ++i) {
        	sum = sum + gas[i % n] - cost[i % n];
        	if (sum < 0) {
        		result = i + 1;
        		sum = 0;
        		if (result >= n) {
        			return -1;
        		}
        	}
        }
        return result;
    }
}

// Another solution:
class Solution {
public:
    int canCompleteCircuit(vector<int> &gas, vector<int> &cost) {

       int start = gas.size()-1;
       int end = 0;
       int sum = gas[start] - cost[start];
       while (start > end) {
          if (sum >= 0) {
             sum += gas[end] - cost[end];
             ++end;
          }
          else {
             --start;
             sum += gas[start] - cost[start];
          }
       }
       return sum >= 0 ? start : -1;
    }
};
