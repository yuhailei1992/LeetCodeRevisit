public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> numsAl = new ArrayList<Integer>();
        for (int i : nums) {
            numsAl.add(i);
        }
        List<Integer> fixed = new ArrayList<Integer>();
        permuteHelper(numsAl, fixed, res);
        return res;
    }
    
    private void permuteHelper(List<Integer> nums, List<Integer> fixed, List<List<Integer>> res) {
        if (nums.size() == 1) {
            List<Integer> validResult = new ArrayList<Integer>();
            validResult.addAll(fixed);
            validResult.add(nums.get(0));
            res.add(validResult);
        } else {
            for (int i = 0; i < nums.size(); i++) {
                int first = nums.get(i);
                // fix one number.
                nums.remove(i);
                fixed.add(first);
                // recursively call permuteHelper.
                permuteHelper(nums, fixed, res);
                // de-fix the number.
                fixed.remove(fixed.size() - 1);
                nums.add(i, first);
            }
        }
    }
}