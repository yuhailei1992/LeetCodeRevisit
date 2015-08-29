// Solution 1: compare every i and j. Time complexity: O(n ^ 2);

public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        // Gets the inverted lists of word1 and word2.
        List<Integer> word1Positions = new ArrayList<>();
        List<Integer> word2Positions = new ArrayList<>();
        
        for (int i = 0; i < words.length; ++i) {
            if (words[i].equals(word1)) {
                word1Positions.add(i);
            } else if (words[i].equals(word2)) {
                word2Positions.add(i);
            }
        }
        
        // Finds the shortest distance.
        int minDistance = Integer.MAX_VALUE;
        for (int i : word1Positions) {
            for (int j : word2Positions) {
                minDistance = Math.min(minDistance, Math.abs(i - j));
            }
        }
        return minDistance;
    }
}

// Solution 2: a lot of duplicate computation. We can prune unnecessary comparisions by eliminating
// the js that are less than i.
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        // Gets the inverted lists of word1 and word2.
        List<Integer> word1Positions = new ArrayList<>();
        Queue<Integer> word2Positions = new LinkedList<>();
        
        for (int i = 0; i < words.length; ++i) {
            if (words[i].equals(word1)) {
                word1Positions.add(i);
            } else if (words[i].equals(word2)) {
                word2Positions.offer(i);
            }
        }
        
        // Finds the shortest distance.
        int minDistance = Integer.MAX_VALUE;
        for (int i : word1Positions) {
            for (int j : word2Positions) {
                minDistance = Math.min(minDistance, Math.abs(i - j));
            }
            // Eliminates the js that are less than i.
            while (!word2Positions.isEmpty() && word2Positions.peek() < i) {
                word2Positions.poll();
            }
        }
        return minDistance;
    }
}

// Solution 3: O(n) solution. Optimal solution.
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1, minDistance = Integer.MAX_VALUE;
        
        for (int i = 0; i < words.length; ++i) {
            if (words[i].equals(word1)) {
                p1 = i;
                if (p2 != -1) {
                    minDistance = Math.min(minDistance, Math.abs(p1 - p2));
                }
            } else if (words[i].equals(word2)) {
                p2 = i;
                if (p1 != -1) {
                    minDistance = Math.min(minDistance, Math.abs(p1 - p2));
                }
            }
        }
        return minDistance;
    }
}