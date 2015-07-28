/**
 * Solution 1: this solution.
 * Solution 2: get two dummyheads, append nodes less than x to dummy1, rest to dummy2,
 *             then concatenate two lists.
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode newHead = new ListNode(0);
        ListNode newTail = newHead;

        // first pass, distill those less than x.
        ListNode p = dummy;
        while (p.next != null) {
            if (p.next.val < x) {
                ListNode toAppend = p.next;
                p.next = p.next.next;
                newTail.next = toAppend;
                newTail = newTail.next;
                newTail.next = null;
            } else {
                p = p.next;
            }
        }
        newTail.next = dummy.next;
        return newHead.next;
    }
}