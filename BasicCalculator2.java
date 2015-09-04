public class Solution {
    public int calculate(String s) {
        String str = preprocess(s);
        String[] tokens = str.split("\\+");
        int sum = 0;
        for (String token : tokens) {
        	sum += eval(token);
        }
        return sum;
    }

    private String preprocess(String s) {
    	StringBuffer sb = new StringBuffer();
    	for (char c : s.toCharArray()) {
    		if (c == ' ') {
    			continue;
    		} else if (c == '-') {
    			sb.append('+');
    		} else if (c == '/') {
    			sb.append('*');
    		}
    		sb.append(c);
    	}
    	return sb.toString();
    }

    // Evaluates muplicates and divides.
    private int eval(String s) {
    	if (s.indexOf('*') == -1 && s.indexOf('/') == -1) {
    		return Integer.parseInt(s);
    	} else {
    		String[] tokens = s.split("\\*");
    		int res = 1;
    		for (String token : tokens) {
    			if (token.charAt(0) == '/') {
    				res /= Integer.parseInt(token.substring(1));
    			} else {
    				res *= Integer.parseInt(token);
    			}
    		}
    		return res;
    	}
    }
}

// Solution 2: use a stack.

public class Solution {
    public int calculate(String s) {
    	char sign = '+';
    	int num = 0;
    	Stack<Integer> stk = new Stack<>();
    	for (int i = 0; i < s.length(); ++i) {
    		char c = s.charAt(i);
    		if (Character.isDigit(c)) {
    			num = num * 10 + (c - '0');
    		}
			// Evalutates the previous number only if it is not space or we are at end.
			if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
				if (sign == '+') {
					stk.push(num);
				} else if (sign == '-') {
					stk.push(-num);
				} else if (sign == '*') {
					stk.push(stk.pop() * num);
				} else {
					stk.push(stk.pop() / num);
				}
				num = 0;
				sign = c;
    		}
    	}
    	// Sum all the results in stack.
    	int sum = 0;
    	for (int n : stk) {
    		sum += n;
    	}
    	return sum;
    }
}
