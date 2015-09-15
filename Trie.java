class TrieNode {
    private static final int NUM_CHILDREN = 26;
    // Initialize your data structure here.
    boolean isWord;
    TrieNode[] children;
    
    public TrieNode() {
        isWord = false;
        children = new TrieNode[NUM_CHILDREN];
    }
}

public class Trie {
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

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");