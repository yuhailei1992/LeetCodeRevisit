
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode toInsert;
        ListNode sortedTail = head;
        while (sortedTail.next != null) {
            toInsert = sortedTail.next;
            sortedTail.next = toInsert.next;
            sortedTail = insertList(dummy, toInsert, sortedTail);
        }
        return dummy.next;
    }

    /**
     * the first parameter is dummyhead, second parameter is the tail of sorted list.
     * returns the new tail.
     */
    private ListNode insertList(ListNode dummy, ListNode toInsert, ListNode sortedTail) {
        for (ListNode p = dummy; p != sortedTail.next; p = p.next) {
            if (p.next == null) {
                p.next = toInsert;
                toInsert.next = null;
                return toInsert;
            } else if (p == sortedTail) {
                toInsert.next = p.next;
                p.next = toInsert;
                return toInsert;
            } else if (p.next.val > toInsert.val) { // insert toInsert after p.
                toInsert.next = p.next;
                p.next = toInsert;
                return sortedTail;
            }
        }
        return sortedTail;
    }
}