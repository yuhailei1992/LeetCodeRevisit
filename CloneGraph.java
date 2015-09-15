/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        // Use bfs to traverse the graph.
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            // Controls how many nodes to poll.
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                // p is guaranteed to have never occurred.
                UndirectedGraphNode p = queue.poll();
                // Clone a node.
                if (!map.containsKey(p.label)) {
                    map.put(p.label, new UndirectedGraphNode(p.label));
                }
                UndirectedGraphNode p2 = map.get(p.label);
                for (UndirectedGraphNode next : p.neighbors) {
                    // Add every neighbor (clone it if necessary) into p2's neighbor.
                    if (!map.containsKey(next.label)) {
                        queue.offer(next);
                        map.put(next.label, new UndirectedGraphNode(next.label));
                    }
                    UndirectedGraphNode next2 = map.get(next.label);
                    p2.neighbors.add(next2);
                }
            }
        }
        return map.get(node.label);
    }
}

// DFS
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        return helper(node, map);
    }
    
    private UndirectedGraphNode helper(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        
        UndirectedGraphNode node2 = new UndirectedGraphNode(node.label);
        map.put(node2.label, node2);
        for (UndirectedGraphNode next : node.neighbors) {
            node2.neighbors.add(helper(next, map));
        }
        return node2;
    }
}