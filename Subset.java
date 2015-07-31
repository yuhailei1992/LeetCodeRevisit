public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (int i = 1; i <= nums.length; ++i) {
        	helper(res, new ArrayList<Integer>(), i, nums, 0);
        }
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> trace, int num, int[] nums, int start) {
    	if (num == 0) {
    		res.add(new ArrayList<Integer>(trace));
    		return;
    	}
        if (start == nums.length) {
            return;
        }
    	for (int i = start; i < nums.length; i++) {
    		trace.add(nums[i]);
    		helper(res, trace, num - 1, nums, i + 1);
    		trace.remove(trace.size() - 1);
    	}
    }
}