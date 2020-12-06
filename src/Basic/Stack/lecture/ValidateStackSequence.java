package Basic.Stack.lecture;

import java.util.Stack;

public class ValidateStackSequence {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int ptr = 0;
        for (int i=0; i<pushed.length; i++) {
            int num = pushed[i];
            stack.push(num);
            while (!stack.isEmpty() && ptr < popped.length && popped[ptr] == stack.peek()) {
                stack.pop();
                ptr ++;
            }
        }
        if (ptr != popped.length) return false;
        return true;
    }

    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,3,5,1,2};
        ValidateStackSequence stackSequence = new ValidateStackSequence();
        boolean res = stackSequence.validateStackSequences(pushed, popped);
        System.out.println(res);
    }
}
