/**
 * Solution 1: use stk0 to store numbers, stk1 to reverse order when pop() or peek();
 * Solution 2: amortized O(1) time complexity:
 */

class MyQueue {
    private Stack<Integer> stk0;
    private Stack<Integer> stk1;
    public MyQueue() {
        stk0 = new Stack<>();
        stk1 = new Stack<>();
    }
    // Push element x to the back of queue.
    public void push(int x) {
        stk0.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while (!stk0.isEmpty()) {
            stk1.push(stk0.pop());
        }
        stk1.pop();
        while (!stk1.isEmpty()) {
            stk0.push(stk1.pop());
        }
    }

    // Get the front element.
    public int peek() {
        while (!stk0.isEmpty()) {
            stk1.push(stk0.pop());
        }
        int res = stk1.peek();
        while (!stk1.isEmpty()) {
            stk0.push(stk1.pop());
        }
        return res;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stk0.isEmpty();
    }
}


/** Solution 2: use stk0 for insert, stk1 for pop. Only move elements from stk0 to stk1 when
 * there is nothing at stk1. Amortized time complexity is O(1)
 */
class MyQueue {
    private Stack<Integer> stk0;
    private Stack<Integer> stk1;
    public MyQueue() {
        stk0 = new Stack<>();
        stk1 = new Stack<>();
    }
    // Push element x to the back of queue.
    public void push(int x) {
        stk0.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        peek();
        stk1.pop();
    }

    // Get the front element.
    public int peek() {
        if (stk1.isEmpty()) {
            while (!stk0.isEmpty()) {
                stk1.push(stk0.pop());
            }
        }
        return stk1.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stk0.isEmpty() && stk1.isEmpty();
    }
}