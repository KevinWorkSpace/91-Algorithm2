package Advanced.ValidBrackets;

import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int max = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.add(i);
            }
            else if (c == ')') {
                stack.pop();
                if (stack.isEmpty()) stack.add(i);
                else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
