public class Solution {
    public int singleNumber(int[] nums) {
        int one = 0, two = 0, three = 0;
        for (int i : nums) {
            // There are existing two bits, and new two bits.
            two = two | (one & i);
            one ^= i;
            three = two & one;
            one &= (~three);
            two &= (~three);
        }
        return one;
    }
}