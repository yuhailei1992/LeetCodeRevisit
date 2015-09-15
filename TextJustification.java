public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0 || maxWidth <= 0) {
        	return res;
        }

        int currLen = 0, int start = 0, int end = 0;
        for (int end = 0; end < words.length; ++end) {
        	if (currLen + words[end].length() <= maxWidth) {
        		currLen += words[end].length();
        		++end;
        	} else {
        		// time to convert.
        		res.add(getString(words, start, end, currLen, maxWidth));
        		// New start.
        		start = end + 1;
        	}
        }
        res.add(getString(words, start, end, currLen, maxWidth));
        return res;
    }

    private String getString(String[] words, int start, int end, int currLen, int maxWidth) {
    	StringBuilder sb = new StringBuilder();
    	// If there is only one word.
    	if (start == end) {
    		sb.append(words[start]);
    		for (int i = maxWidth - currLen; i > 0;  --i) {
    			sb.append(' ');
    		}
    		return sb.toString();
    	} else {
    		int totalSpace = maxWidth - currLen;
    		int regular = (int)Math.ceil(totalSpace / (double)(end - start));

    		while (start < end) {
    			sb.append(words[start++]);
    			int numSpace = totalSpace >= regular ? regular : totalSpace;
    			totalSpace -= regular;
    			for (int i = 0; i < numSpace; ++i) {
    				sb.append(' ');
    			}
    		}
    		// Appends the last word.
    		sb.append(words[end]);
    		return sb.toString();
    	}
    }
}