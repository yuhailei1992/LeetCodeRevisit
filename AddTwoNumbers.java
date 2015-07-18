/**
 * Solution 1: O(n) space, O(n) time. Keep creating new nodes for added digits.
 * Solution 2: O(1) space, O(n) time. Store added digits in both lists (destroying original node),
 *             create new node for residual carry.
 * Solution 3: recursive.
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

// Recursive solution (from leetcode discussion)
public ListNode addTwoNumbersWithCarryOver(ListNode l1, ListNode l2, int carryOver) {
    if (l1 == null) {
        return carryOver == 0 ? l2 : addTwoNumbersWithCarryOver(new ListNode(carryOver), l2, 0);
    }

    if (l2 == null) {
        return carryOver == 0 ? l1 : addTwoNumbersWithCarryOver(l1, new ListNode(carryOver), 0);
    }

    int sumVal = l1.val + l2.val + carryOver;
    ListNode returnVal = new ListNode(sumVal % 10);
    returnVal.next = addTwoNumbersWithCarryOver(l1.next, l2.next, sumVal / 10);
    return returnVal;
}