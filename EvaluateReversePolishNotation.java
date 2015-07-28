public class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> op = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

        Stack<Integer> stk = new Stack<>();
        for (String s : tokens) {
            if (op.contains(s)) {
                // pop two, do the op, and push
                int tmp = 0;
                switch(s) {
                case "+":
                    tmp = stk.pop() + stk.pop();
                    break;
                case "-":
                    tmp = 0 - stk.pop() + stk.pop();
                    break;
                case "*":
                    tmp = stk.pop() * stk.pop();
                    break;
                case "/":
                    int divisor = stk.pop();
                    int dividend = stk.pop();
                    tmp = dividend / divisor;
                    break;
                default:
                    break;
                }
                stk.push(tmp);
            } else {
                stk.push(Integer.parseInt(s));
            }
        }
        return stk.pop();
    }
}