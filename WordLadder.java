public class Solution {
    // To find the shortest, use BFS.
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if (beginWord.equals(endWord)) {
            return 0;
        }
        int depth = 1;
        // Use a hashset to store the visited words.
        Set<String> set = new HashSet<>();
        // Initialize a queue, put every adjacent word into it.
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        set.add(beginWord);
        // BFS.
        while (!queue.isEmpty()) {
            depth++;
            int currSize = queue.size();
            for (int i = 0; i < currSize; ++i) {
                String curr = queue.poll();
                // For every of the characters,
                for (int j = 0; j < curr.length(); ++j) {
                    char prev = curr.charAt(j);
                    // Replace the char with every other char, 
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (c != prev) {
                            String s = new StringBuilder(curr).deleteCharAt(j).insert(j, c).toString();
                            if (!set.contains(s) && wordDict.contains(s)) {
                                if (s.equals(endWord)) {
                                    return depth;
                                }
                                queue.add(s);
                                set.add(s);
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }
}