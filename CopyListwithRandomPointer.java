/**
 * Solution 1: use a hashmap.
 * Solution 2:
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }

        HashMap<RandomListNode, RandomListNode> hm = new HashMap<>();
        // 1, make a shadow list.
        RandomListNode p = head;
        RandomListNode newHead = new RandomListNode(0);
        RandomListNode newTail = newHead;
        while (p != null) {
            RandomListNode p2 = new RandomListNode(p.label);
            newTail.next = p2;
            newTail = p2;
            newTail.next = null;
            hm.put(p, p2); // store the mapping from orig node to new node.
            p = p.next;
        }
        // 2, fix the random pointers.
        for (p = head; p != null; p = p.next) {
            hm.get(p).random = hm.get(p.random);
        }
        return newHead.next;
    }
}

// Solution 2: use a shadow pointer.
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }

        // 1, copy the original list by inserting copied node after original node.
        for (RandomListNode p = head; p != null; p = (p.next == null ? null : p.next.next)) {
            RandomListNode pCopy = new RandomListNode(p.label);
            pCopy.next = p.next;
            p.next = pCopy;
        }
        // 2, fix the random pointers.
        for (RandomListNode p = head; p != null; p = (p.next == null ? null : p.next.next)) {
            p.next.random = (p.random == null ? null : p.random.next);
        }
        // 3, separate lists.
        RandomListNode newHead = new RandomListNode(0);
        RandomListNode newTail = newHead;
        for (RandomListNode p = head; p != null; p = p.next) {
            RandomListNode pCopy = p.next;
            p.next = p.next.next;
            newTail.next = pCopy;
            newTail = newTail.next;
            newTail.next = null;
        }
        return newHead.next;
    }
}