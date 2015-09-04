public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> hm = new HashMap<>();
        for (String s : strings) {
        	String signature = getSignature(s);
        	if (hm.containsKey(signature)) {
        		hm.get(signature).add(s);
        	} else {
        		List<String> strs = new ArrayList<>();
        		strs.add(s);
        		hm.put(signature, strs);
        	}
        }
        // Return the groups.
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : hm.entrySet()) {
        	res.add(entry.getValue());
        }
        return res;
    }

    private String getSignature(String s) {
    	StringBuilder sb = new StringBuilder();
    	sb.append(0);
    	for (int i = 1; i < s.length(); ++i) {
    		int offset = s.charAt(i) - s.charAt(0);
    		if (offset < 0) {
    			offset += 26;
    		}
    		sb.append(offset);
    	}
    	return sb.toString();
    }
}