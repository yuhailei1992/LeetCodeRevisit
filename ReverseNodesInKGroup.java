/** Reverse Nodes in K Group
 *
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        while (hasKLeft(pre.next, k)) {
            pre = reverseKNodes(pre, k);
        }
        return dummy.next;
    }

    private ListNode reverseKNodes(ListNode pre, int k) {
        ListNode curr = pre.next;
        ListNode post;

        for (; k > 1; k--) {
            post = curr.next;
            // reverse
            curr.next = post.next;
            post.next = pre.next;
            pre.next = post;
        }
        return curr;
    }

    private boolean hasKLeft(ListNode node, int k) {
        for (; k > 0 && node != null; k--, node = node.next) {
            // do nothing.
        }
        return k == 0;
    }
}