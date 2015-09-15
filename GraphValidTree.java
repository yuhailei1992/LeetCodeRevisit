public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        // Construct adjacent list graph.
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            adjList.add(new ArrayList<>());
        }
        // Add every edge into the adjacent list.
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        // BFS
        if (hasCycle(adjList, 0, visited, -1)) {
            return false;
        }
        // Judge if every node has been visited.
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
    
    private boolean hasCycle(List<List<Integer>> adjList, int start, boolean[] visited, int parent) {
        visited[start] = true;
        for (int adj : adjList.get(start)) {
            // if this node is visited and we are not from this node, there is a cycle.
            if (visited[adj] && parent != adj) {
                return true;
            }
            // if this neighbor has not been visited and we detect a cycle in it, return true.
            if (!visited[adj] && hasCycle(adjList, adj, visited, start)) {
                return true;
            }
        }
        return false;
    }
}