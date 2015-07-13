
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode toInsert;
        // find the pre node of the part to reverse.
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        // reverse the desired part.
        ListNode p = pre.next;
        for (int i = 0; i < n - m; i++) {
            toInsert = p.next;
            p.next = toInsert.next;
            toInsert.next = pre.next;
            pre.next = toInsert;
        }
        return dummy.next;
    }
}