// Solution 1:
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> numsAl = new ArrayList<>();
        for (int i : nums) {
            numsAl.add(i);
        }
        List<Integer> fixed = new ArrayList<Integer>();
        permuteHelper(numsAl, fixed, res);
        return res;
    }
    
    private void permuteHelper(List<Integer> nums, List<Integer> fixed, List<List<Integer>> res) {
        if (nums.size() == 1) {
            fixed.add(nums.get(0));
            res.add(new ArrayList<>(fixed));
            fixed.remove(fixed.size() - 1);
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

// Solution 2: use a boolean[] for visited.

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(res, new ArrayList<Integer>(), nums, visited);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> trace, int[] nums, boolean[] visited) {
        if (trace.size() == visited.length) {
            res.add(new ArrayList<>(trace));
        }
        for (int i = 0; i < visited.length; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                trace.add(nums[i]);
                dfs(res, trace, nums, visited);
                trace.remove(trace.size() - 1);
                visited[i] = false;
            }
        }
    }
}

// Solution 3: swap.
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, nums.length);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, int[] nums, int n) {
        if (n == 1) {
            List<Integer> t = new ArrayList<>();
            for (int i : nums) {
                t.add(i);
            }
            res.add(t);
        } else {
            for (int i = 0; i < n; ++i) {
                swap(nums, i, n - 1);
                dfs(res, nums, n - 1);
                swap(nums, i, n - 1);
            }
        }
    }
    
    private void swap(int[] a, int i, int j) {
        int c = a[i];
        a[i] = a[j];
        a[j] = c;
    }
}