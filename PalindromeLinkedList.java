/** Palindrome Linked List
 * Solution 1: reverse the entire linkedlist and compare with original. O(n) space, O(n) time.
 * Solution 2: use a stack. Push the first half and pop the second half.
 * Solution 3: use an array. Copy everything to the array, and judge if it is a palindrome.
 * Solution 4: use two pointers: pFast and pSlow. When pFast reaches end, pSlow is at midpoint;
 *             reverse the first half when pSlow moves. The use two pointers to judge if the 
 *             list is a palindrome.
 *             For example: a -> b -> c becomes a <- b -> c. Then we can start b and compare the 
 *             two parts using two pointers. This method cannot be implemented. 
 * Solution 5: reverse the second half, and compare with the first half. 
 */

public class Solution {
    public boolean isPalindrome(ListNode head) {
        // 0, corner cases.
        if (head == null || head.next == null) {
            return true;
        }
        
        // 1, find midpoint. Reverse the first half along the way.
        ListNode 
    }
}


