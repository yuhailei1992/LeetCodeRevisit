class MinStack {
	private Stack<Integer> data;
	private int min = Integer.MAX_VALUE;

    public void push(int x) {
        // Only push the min when x is smaller than min.
        if (x <= min) {
        	data.push(min);
        	min = x;
        }
        data.push(x);
    }

    public void pop() {
        if (data.peek() == min) {
        	data.pop();
        	min = data.peek();
        }
        data.pop();
        if (data.isEmpty()) {
        	min = Integer.MAX_VALUE;
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min;
    }
}
