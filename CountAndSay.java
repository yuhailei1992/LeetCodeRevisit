public class Solution {
    public String countAndSay(int n) {
        if (n == 0) {
            return "1";
        }
        String curr = "1";
        for (int i = 1; i < n; i++) {
            String prev = curr;
            curr = "";
            int currChar = prev.charAt(0);
            int currCnt = 1;
            for (int j = 1; j < prev.length(); j++) {
                if (prev.charAt(j) == currChar) {
                    currCnt++;
                } else {
                    curr = curr + currCnt + currChar;
                    currChar = prev.charAt(j);
                    currCnt = 1;
                }
            }
            curr = curr + currCnt + currChar;
        }
        return curr;
    }
}