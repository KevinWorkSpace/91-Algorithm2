package Advanced.Design;

import java.util.Stack;

public class CQueue {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        s1.add(value);
    }

    public int deleteHead() {
        if (!s2.isEmpty()) {
            return s2.pop();
        }
        else {
            if (s1.isEmpty()) return -1;
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return s2.pop();
        }
    }
}
