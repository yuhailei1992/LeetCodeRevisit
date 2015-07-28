public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        // container for result.
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        // container for trace.
        List<Integer> trace = new ArrayList<Integer>();
        // top level iteration.
        helper(res, trace, n, 1, k);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> trace, int n, int index, int target) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(trace));
            return;
        }
        for (int i = index; i <= n; i++) {
            trace.add(i);
            helper(res, trace, n, i + 1, target - 1);
            trace.remove(trace.size() - 1);
        }
    }
}

// Solution 2: iterative.


// Solution 3: mathematical. 

