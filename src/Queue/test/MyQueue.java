package Queue.test;

import java.util.Stack;

public class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!s2.isEmpty()) {
            s1.add(s2.pop());
        }
        s1.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!s1.isEmpty()) {
            s2.add(s1.pop());
        }
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        while (!s1.isEmpty()) {
            s2.add(s1.pop());
        }
        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
