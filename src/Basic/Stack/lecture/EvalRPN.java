package Basic.Stack.lecture;

import java.util.Stack;

public class EvalRPN {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<tokens.length; i++) {
            String c = tokens[i];
            int n1 = 0;
            int n2 = 0;
            switch (c) {
                case  "+":
                    n1 = stack.pop();
                    n2 = stack.pop();
                    stack.push(n1 + n2);
                    break;

                case "-":
                    n1 = stack.pop();
                    n2 = stack.pop();
                    stack.push(n2 - n1);
                    break;

                case "*":
                    n1 = stack.pop();
                    n2 = stack.pop();
                    stack.push(n2 * n1);
                    break;

                case "/":
                    n1 = stack.pop();
                    n2 = stack.pop();
                    stack.push(n2 / n1);
                    break;

                default:
                    stack.push(Integer.parseInt(c));
                    break;
            }
        }
        return stack.peek();
    }
}
