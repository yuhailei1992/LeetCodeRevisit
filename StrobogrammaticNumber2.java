public class Solution {
	// 0, 1, 8 are universal; 6 and 9 must match each other.
	private static Map<Integer, Integer> hm = new HashMap<>();
	hm.put(0, 0);
	hm.put(1, 1);
	hm.put(6, 9);
	hm.put(8, 8);
	hm.put(9, 6);

    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        res.addAll(helper(n, true));
        return res;
    }
    
    private List<String> helper(int n, boolean isHead) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
        	res.add("")
        } else if (n == 1) {
        	res.addAll(Arrays.asList(0, 1, 8));
        } else {
        	for (int i : hm.entrySet()) {
        		if (i == 0 && isHead) {
        			continue;
        		}
        		for (String sub : helper(n - 2, false)) {
        			res.add(Integer.toString(i) + sub + Integer.toString(hm.get(i)));
        		}
        	}
        }
        return res;
    }
}