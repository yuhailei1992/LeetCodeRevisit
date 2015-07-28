public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<String>();
        if (strs == null || strs.length == 0) {
            return res;
        }

        HashMap<String, String> hm = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String curr = strs[i];
            char[] charArr = curr.toCharArray();
            Arrays.sort(charArr);
            String sorted = new String(charArr);
            if (hm.containsKey(sorted)) {
                if (hm.get(sorted).length() == 0 || hm.get(sorted).charAt(0) != '*') { // first time insert.
                    res.add(hm.get(sorted));
                    hm.put(sorted, "*" + hm.get(sorted));
                }
                res.add(curr);
            } else {
                hm.put(sorted, curr);
            }
        }
        return res;
    }
}

// Solution 2: create a hashCode method which returns the same result for anagrams.
