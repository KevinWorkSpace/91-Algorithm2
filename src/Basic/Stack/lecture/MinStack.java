package Basic.Stack.lecture;

import java.util.Stack;

class MinStack {

    Stack<Integer> s1;
    Stack<Integer> s2;

    /** initialize your data structure here. */
    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
        if (s2.isEmpty() || x <= s2.peek()) {
            s2.push(x);
        }
    }

    public void pop() {
        int num = s1.pop();
        if (num == s2.peek()) {
            s2.pop();
        }
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }
}
