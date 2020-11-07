package Stack.lecture.MonostoneStack;

import java.util.Stack;

public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i=0; i<heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int tmp = stack.pop();
                int distance = 0;
             if (stack.isEmpty()) {
                    distance = i;
                }
                else distance = i - stack.peek() - 1;
                max = Math.max(max, distance * heights[tmp]);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int tmp = stack.pop();
            int distance = 0;
            if (stack.isEmpty()) {
                distance = heights.length;
            }
            else distance = heights.length - stack.peek() - 1;
            max = Math.max(max, distance * heights[tmp]);
        }
        return max;
    }
}
