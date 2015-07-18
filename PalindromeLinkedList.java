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
        
        // 1, reverse the first part.
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode s = dummy;
        ListNode f = dummy;
        ListNode sNext = s.next;
        ListNode sPre = null;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = sNext;
            sNext = s.next;
            s.next = sPre;
            sPre = s;
        }
        
        // 2, compare(odd - even).
        ListNode p1, p2;
        if (f == null) { // odd number of nodes.
            p1 = s.next;
            p2 = sNext;
        } else {
            p1 = s;
            p2 = sNext;
        }
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1 == null && p2 == null;
    }
}
