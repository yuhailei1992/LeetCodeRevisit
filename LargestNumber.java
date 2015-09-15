public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length() == 0) {
        	return "0";
        }
        String[] strArr = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
        	strArr[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strArr, numStrComparator);
        if (strArr[0].charAt(0) == '0') {
        	return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
        	sb.append(str);
        }
        return sb.toString();
    }

    private Comparator<String> numStrComparator = new Comparator<>() {
    	public int compare(String s1, String s2) {
    		return (s1 + s2).compareTo(s2 + s1);
    	}
    };
}

// solution: greedy. sort and concatenate all of them: fail.
// solution: 