package Basic.Stack.lecture;

public class CustomStack {

    int[] stack;
    int cnt;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        cnt = 0;
    }

    public void push(int x) {
        if (cnt < stack.length) {
            stack[cnt++] = x;
        }
    }

    public int pop() {
        if (cnt > 0) {
            cnt --;
            return stack[cnt];
        }
        return -1;
    }

    public void increment(int k, int val) {
        int num = Math.min(k, cnt);
        for (int i=0; i<num; i++) {
            stack[i] += val;
        }
    }
}
