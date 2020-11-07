package Stack.lecture.MonostoneStack;

import java.util.Stack;

public class MonostoneStack {


    public int[] monostoneStack(int[] num) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[num.length];
        for (int i=0; i<num.length; i++) {
            while (!stack.isEmpty() && num[stack.peek()] > num[i]) {
                int tmp = stack.pop();
                res[tmp] = i;
            }
            stack.push(num[i]);
        }
        return res;
    }
}
