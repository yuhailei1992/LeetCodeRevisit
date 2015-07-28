public class Solution {
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        
        int sign = 1;
        int result = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (Character.isDigit(curr)) {
                temp = temp * 10 + (int)(curr - '0');
            } else {
                switch (s.charAt(i)) {
                    case '+':
                        result += sign * temp;
                        temp = 0;
                        sign = 1;
                        break;
                    case '-':
                        result += sign * temp;
                        temp = 0;
                        sign = -1;
                        break;
                    case '(':
                        stk.push(result);
                        stk.push(sign);
                        result = 0;
                        temp = 0;
                        sign = 1;
                        break;
                    case ')':
                        result += sign * temp;
                        result *= stk.pop();
                        result += stk.pop();
                        temp = 0;
                        sign = 1;
                        break;
                    case ' ':
                        break;
                    default:
                        break;
                }
            }
        }
        if (temp != 0) {
            result += sign * temp;
        }
        return result;
    }
}