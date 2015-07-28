
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // 1, find the midpoint.
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode f = dummy;
        ListNode s = dummy;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }
        // 2, reverse the second part.
        ListNode newTail = s.next;
        while (newTail != null && newTail.next != null) {
            ListNode toAppendAfterHead = newTail.next;
            newTail.next = toAppendAfterHead.next;
            toAppendAfterHead.next = s.next;
            s.next = toAppendAfterHead;
        }
        // 3, interleave two sublists.
        ListNode dummy2 = new ListNode(0);
        dummy2.next = s.next;
        s.next = null;
        ListNode dummy3 = new ListNode(0);
        ListNode mergedTail = dummy3;
        boolean flag = true;
        while (dummy.next != null && dummy2.next != null) {
            if (flag) {
                mergedTail.next = dummy.next;
                dummy.next = dummy.next.next;
            } else {
                mergedTail.next = dummy2.next;
                dummy2.next = dummy2.next.next;
            }
            mergedTail = mergedTail.next;
            mergedTail.next = null;
            flag = !flag;
        }
        if (dummy.next != null) {
            mergedTail.next = dummy.next;
        } else {
            mergedTail.next = dummy2.next; // could be null.
        }
    }
}