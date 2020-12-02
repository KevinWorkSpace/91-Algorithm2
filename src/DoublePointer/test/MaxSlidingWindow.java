package DoublePointer.test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int cnt = 0;
        Deque<Integer> queue = new LinkedList<>();
        for (int i=0; i<k; i++) {
            if (queue.isEmpty()) {
                queue.add(nums[i]);
            }
            else {
                while (!queue.isEmpty() && nums[i] > queue.peekLast()) {
                    queue.pollLast();
                }
                queue.add(nums[i]);
            }
        }
        res[cnt++] = queue.peek();
        for (int i=1; i<=nums.length-k; i++) {
            while (!queue.isEmpty() && nums[i+k-1] > queue.peekLast()) {
                queue.pollLast();
            }
            queue.add(nums[i+k-1]);
            if (queue.peek() == nums[i-1]) {
                queue.poll();
            }
            res[cnt++] = queue.peek();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        maxSlidingWindow.maxSlidingWindow(nums, 3);

    }
}


