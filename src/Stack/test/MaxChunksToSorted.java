package Stack.test;

import java.util.Stack;

public class MaxChunksToSorted {

    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<arr.length; i++) {
            if (!stack.isEmpty() && arr[i] < stack.peek()) {
                int cur = stack.pop();
                while (!stack.isEmpty() && arr[i] < stack.peek()) {
                    stack.pop();
                }
                stack.push(cur);
            }
            else {
                stack.push(arr[i]);
            }
        }
        return stack.size();
    }
}
