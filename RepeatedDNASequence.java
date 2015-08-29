public class Solution {
	private static final Map<Character, Integer> map = new HashMap<>();
	static {map.put('A', 0); map.put('C', 1); map.put('G', 2); map.put('T', 3);}

    public List<String> findRepeatedDnaSequences(String s) {
    	List<String> res = new ArrayList<>();
        if (s == null || s.length() <= 10) {
        	return res;
        }

        char[] map = new char[2 << 20];
        for (int i = 0; i < s.length() - 9; ++i) {
        	String curr = s.substring(i, i + 10);
        	int hash = generateValue(curr);
        	if (map[hash] == 1) {
        	    map[hash] = 2; // this combination has been added.
        		res.add(curr);
        	} else if (map[hash] == 0) {
        		map[hash] = 1;
        	}
        }
        return res;
    }

    private int generateValue(String s) {
    	int sum = 0;
    	for (int i = 0; i < s.length(); ++i) {
    		sum *= 4;
    		sum += map.get(s.charAt(i));
    	}
    	return sum;
    }
}

// This method can be made faster by using rolling hash.
