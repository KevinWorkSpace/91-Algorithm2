package Basic.Stack.lecture;

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        Stack<Integer> stack_multi = new Stack<>();
        Stack<String> stack_res = new Stack<>();
        int multi = 0;
        StringBuffer res = new StringBuffer();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                multi = multi * 10 + Character.getNumericValue(c);
            }
            else if (Character.isLetter(c)) {
                res.append(c);
            }
            else if (c == '[') {
                stack_multi.add(multi);
                stack_res.add(res.toString());
                multi = 0;
                res = new StringBuffer();
            }
            else if (c == ']') {
                int cur_multi = stack_multi.pop();
                StringBuffer tmp = new StringBuffer();
                for (int j=0; j<cur_multi; j++) {
                    tmp.append(res);
                }
                res = new StringBuffer(stack_res.pop() + tmp);
            }
        }
        return res.toString();
    }
}
