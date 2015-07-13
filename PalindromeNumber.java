/** Palindrome number
 * Corner cases:
 * if reverse and compare, be ware of overflow.
 * Solution 1: reverse and compare.
 *             why it doesn't break corner case? Because the numbers that can overflow when
 *             reversed are not palindrome numbers.
 * Solution 2: get the digits from two sides.
 */

public class Solution {
    public boolean isPalindrome(int x) {
        // negative numbers are not palindromes.
        if (x < 0) {
            return false;
        }
        // single digit numbers are palindromes.
        if (x < 10) {
            return true;
        }
                int power = (int)Math.log10(x);
        for (int i = power; i > power / 2; i--) {
            int leftDigit = x / (int)(Math.pow(10, i)) % 10;
            int rightDigit = x / (int)Math.pow(10, power - i) % 10;
            if (leftDigit != rightDigit) {
                return false;
            }
        }
        return true;
    }

    // solution 1:
    public boolean isPalindrome2(int x) {
        // negative numbers are not palindromes.
        if (x < 0) {
            return false;
        }
        // single digit numbers are palindromes.
        if (x < 10) {
            return true;
        }
        // reverse the number and compare.
        int reversed = 0;
        int xTemp = x;
        while (xTemp > 0) {
            reversed *= 10;
            reversed += (xTemp % 10);
            xTemp /= 10;
        }
        
        return reversed == x;
    }
}