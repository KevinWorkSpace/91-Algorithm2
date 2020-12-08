package Advanced.ValidBrackets;

import java.util.Stack;

public class IsValid {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '[':
                case '{':
                case '(':
                    stack.add(c);
                    break;
                case ')':
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != '[') {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "([)]";
        IsValid isValid = new IsValid();
        boolean res = isValid.isValid(s);
        System.out.println(res);
    }
}
