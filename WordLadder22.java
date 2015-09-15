public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordDict) {
        List<List<String>> res = new ArrayList<>();
		if (beginWord.equals(endWord)) {
			return res;
		}

		Map<String, List<String>> trace = new HashMap<>();
		// Use a hashset to store the visited words.
		Set<String> set = new HashSet<>();
		// Initialize a queue, put every adjacent word into it.
		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		set.add(beginWord);
		boolean found = false;
		// BFS.
		while (!queue.isEmpty() && !found) {
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
							if (!set.contains(s) && (wordDict.contains(s) || s.equals(endWord))) {
								if (s.equals(endWord)) {
									found = true;
								} else {
									set.add(s);
								}
								queue.add(s);
								// Add this trace to trace.
								if (trace.containsKey(s)) {
									trace.get(s).add(curr);
								} else {
									List<String> tmp = new ArrayList<>();
									tmp.add(curr);
									trace.put(s, tmp);
								}
							}
						}
					}
				}
			}
		}
		// Generates the traces according to the hashmap.
		List<String> route = new ArrayList<>();
		dfs(res, route, trace, endWord, beginWord);
		// Reverse all the strings.
		List<List<String>> newRes = new ArrayList<>();
		for (List<String> ls : res) {
			List<String> newLs = new ArrayList<>();
			newLs.add(beginWord);
			for (int i = ls.size() - 1; i >= 0; --i) {
				newLs.add(ls.get(i));
			}
			newRes.add(newLs);
		}
		return newRes;
    }
    
    private void dfs(List<List<String>> res, List<String> route, Map<String, List<String>> map, String curr, String target) {
        if (curr.equals(target)) {
            res.add(new ArrayList<>(route));
        }
        if (!map.containsKey(curr)) {
            return;
        }
        List<String> nextStep = map.get(curr);
        route.add(curr);
        for (String s : nextStep) {
            dfs(res, route, map, s, target);
        }
        route.remove(route.size() - 1);
    }
}
