public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.isEmpty()) {
            return path;
        }

        Deque<String> stk = new ArrayDeque<String>();
        for (String curr : path.split("/")) {
            if (curr.equals("") || curr.equals(".")) {
                continue;
            } else if (curr.equals("..")) {
                if (!stk.isEmpty()) {
                    stk.pollLast();
                }
            } else {
                stk.addLast(curr);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append("/").append(stk.poll());
        }
        if (sb.length() == 0) {
            return "/";
        } else {
            return sb.toString();
        }
    }
}