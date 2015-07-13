
public class Solution {
    private class ListNodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode x, ListNode y) {
            if (x.val < y.val) {
                return -1;
            } else if (x.val == y.val) {
                return 0;
            } else {
                return 1;
            }
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        ListNode toAppend;
        
        // build initial queue.
        Comparator<ListNode> comparator = new ListNodeComparator();
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, comparator);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }
        
        // poll the smallest from queue and append to the merged list.
        while (!queue.isEmpty()) {
            toAppend = queue.poll();
            if (toAppend.next != null) {
                queue.offer(toAppend.next);
            }
            p.next = toAppend;
            p = toAppend;
            p.next = null;
        }
        
        return dummy.next;
    }
}