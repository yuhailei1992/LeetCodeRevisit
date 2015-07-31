import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] findTarget(int[] nums, int target) {
        int[] result = new int[2];
        Arrays.fill(result, -1);
        if (nums == null || nums.length == 0) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // so that we don't need to check if target == totalSum.
        int totalSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            totalSum += nums[i];
            if (map.containsKey(totalSum - target)) {
                result[0] = map.get(totalSum - target) + 1;
                result[1] = i;
                break;
            }
            map.put(totalSum, i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4};
        int[] result = new Solution().findTarget(nums, 4);
        System.out.println(result[0] + " " + result[1]);
    }
}