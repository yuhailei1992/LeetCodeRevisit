public class Solution {
    public List<List<String>> solveNQueens(int n) {
    	List<List<String>> res = new ArrayList<>();
    	if (n <= 0) {
    		return res;
    	}
    	// Records if a certain col or slope has been taken place.
    	boolean[] col = new boolean[n];
    	boolean[] rmc = new boolean[2 * n + 1];
    	boolean[] rpc = new boolean[2 * n + 1];
        dfs(res, 0, n, new ArrayList<Integer>(), col, rmc, rpc);
        return res;
    }

    private void dfs(List<List<String>> res, int i, int n, List<Integer> trace, boolean[] col, boolean[] rmc, boolean[] rpc) {
    	if (i == n) {
    		// Adds to results.
    		res.add(printTrace(trace));
    	} else {
    		// Tries different things in layer level.
	    	for (int j = 0; j < n; ++j) {
	    		int imj = i - j + n - 1, ipj = i + j;
	    		if (col[j] || rmc[imj] || rpc[ipj]) {
	    			continue;
	    		}
	    		col[j] = true; rmc[imj] = true; rpc[ipj] = true;
	    		trace.add(j);
	    		dfs(res, i + 1, n, trace, col, rmc, rpc);
	    		trace.remove(trace.size() - 1);
	    		col[j] = false; rmc[imj] = false; rpc[ipj] = false;
	    	}
    	}
    }

    private List<String> printTrace(List<Integer> trace) {
    	int n = trace.size();
    	List<String> res = new ArrayList<>();
    	StringBuilder sb = new StringBuilder();
    	for (int i : trace) {
    		for (int j = 0; j < n; ++j) {
    			sb.append(i == j ? 'Q' : '.');
    		}
    		res.add(sb.toString());
    		sb.setLength(0);
    	}
    	return res;
    }
}