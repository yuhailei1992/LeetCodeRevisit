tion for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // O(n) space, O(n) time.
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        int val = 0;
        int carry = 0;
        
        while (l1 != null || l2 != null) {
            val = carry + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            p.next = new ListNode(val % 10);
            p = p.next;
            carry = val / 10;
            l1 = (l1 == null ? null : l1.next);
            l2 = (l2 == null ? null : l2.next);
        }
        
        if (carry != 0) {
            p.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
