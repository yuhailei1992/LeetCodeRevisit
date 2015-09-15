public class Solution {
    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        if (words == null || words.length == 0 || board.length == 0 || board[0].length == 0) {
    		return new ArrayList<>(res);
    	}
        // Constructs a trie and insert every word to it.
        Trie trie = new Trie();
        for (String s : words) {
            trie.insert(s);
        }
        
        // Fins all the words that occurred.
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dfs(res, board, visited, "", i, j, trie);
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(Set<String> res, char[][] board, boolean[][] visited, String prefix, int row, int col, Trie trie) {
        // Check for indexoutofbound.
    	if (row < 0 || row >= board.length || col < 0 || col >= board[0].length // boundary check;
    		|| visited[row][col]) {
    		return;
    	}
    	
    	prefix += board[row][col];
    	if (!trie.startsWith(prefix)) {
    	    return;
    	}
    	// The word exists.
    	if (trie.search(prefix)) {
    	    res.add(prefix);
    	}

    	visited[row][col] = true;
    	for (int[] dir : dirs) {
    	    dfs(res, board, visited, prefix, row + dir[0], col + dir[1], trie);
    	}
    	visited[row][col] = false;
    }
    
    private static class TrieNode {
        private static final int NUM_CHILDREN = 26;
        // Initialize your data structure here.
        boolean isWord;
        TrieNode[] children;
        
        public TrieNode() {
            isWord = false;
            children = new TrieNode[NUM_CHILDREN];
        }
    }
    
    private static class Trie {
        private TrieNode root;
    
        public Trie() {
            root = new TrieNode();
        }
    
        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                int childIndex = (int)(c - 'a');
                if (p.children[childIndex] == null) {
                    p.children[childIndex] = new TrieNode();
                }
                p = p.children[childIndex];
            }
            p.isWord = true;
        }
    
        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                int childIndex = (int)(c - 'a');
                if (p.children[childIndex] == null) {
                    return false;
                }
                p = p.children[childIndex];
            }
            return p.isWord;
        }
    
        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode p = root;
            for (char c : prefix.toCharArray()) {
                int childIndex = (int)(c - 'a');
                if(p.children[childIndex] == null) {
                    return false;
                }
                p = p.children[childIndex];
            }
            return true;
        }
    }
}
