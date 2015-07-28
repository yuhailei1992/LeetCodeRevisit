
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int dupValue;
        boolean hasDup = false;
        // remove dup.
        for (ListNode p = dummy; p != null && p.next != null && p.next.next != null; ) {
            // 1, check if there are duplicates, and set the dup value;
            if (p.next.val == p.next.next.val) {
                dupValue = p.next.val;
                hasDup = true;
                // 2, delete the nodes with dup value.
                while (p.next != null && p.next.val == dupValue) {
                    p.next = p.next.next;
                }
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }
}

// Solution 2: recursive, copied from leetcode discussion.
public ListNode deleteDuplicates(ListNode head) {
    if (head == null) return null;

    if (head.next != null && head.val == head.next.val) {
        while (head.next != null && head.val == head.next.val) {
            head = head.next;
        }
        return deleteDuplicates(head.next);
    } else {
        head.next = deleteDuplicates(head.next);
    }
    return head;
}