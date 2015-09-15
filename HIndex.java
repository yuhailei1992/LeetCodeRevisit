public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        
        Arrays.sort(citations);
        int len = citations.length;
        // corner case: all citations are greater than h.
        if (citations[0] >= len) {
            return len;
        }
        // general cases.
        for (int i = len - 1; i > 0; --i) {
            if (citations[len - i] >= i && citations[len - i - 1] <= i) {
                return i;
            }
        }
        return 0;
    }
}

// A O(n) solution using O(n) space.
public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        
        int len = citations.length;
        int[] arr = new int[len + 1];
        for (int i : citations) {
            if (i >= len) {
                arr[len]++;
            } else {
                arr[i]++;
            }
        }
        
        if (arr[len] >= len) {
            return len;
        } else {
            for (int i = len - 1; i > 0; --i) {
                arr[i] += arr[i + 1];
                if (arr[i] >= i) {
                    return i;
                }
            }
        }
        return 0;
    }
}