
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        // let fast and slow pointers meet.
        ListNode f = head;
        ListNode s = head;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
            if (f == s) {
                break;
            }
        }
        if (f == null || f.next == null) {
            return null;
        }
        // find the bifurcate.
        ListNode p = head;
        while (p != s) {
            p = p.next;
            s = s.next;
        }
        return p;
    }
}