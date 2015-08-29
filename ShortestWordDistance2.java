public class WordDistance {
    
    private final Map<String, Map<String, Integer>> distance;

    public WordDistance(String[] words) {
    	distance = new HashMap<>();
    }

    public int shortest(String word1, String word2) {
    	// Sort the two words.
    	if (word1.compareTo(word2) > 0) {
    		String tmp = word2;
    		word2 = word1;
    		word1 = tmp;
    	}

    	// Try to get from cache.
        if (distance.containsKey(word1)) {
        	if (distance.get(word1) != null && distance.get(word1).containsKey(word2)) {
        		return distance.get(word1).get(word2);
        	}
        }

        // Calculate the shortest distance.
        int dist = shortestDistance(words, word1, word2);

        // Put in map.
        if (!distance.containsKey(word1)) {
        	Map<String, Integer> entry = new HashMap<>();
        	entry.put(word2, dist);
        	distance.put(word1, entry);
        } else {
        	distance.get(word1).put(word2, dist);
        }

        // Return the distance.
        return dist;
    }

    private int shortestDistance(String[] words, String word1, String word2) {
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

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");