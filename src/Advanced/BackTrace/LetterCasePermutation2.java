package Advanced.BackTrace;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation2 {

    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        StringBuffer path = new StringBuffer();
        backTrace(res, S, path, 0);
        return res;
    }

    public void backTrace(List<String> res, String S, StringBuffer path, int start) {
        if (path.length() == S.length()) {
            res.add(path.toString());
            return;
        }
        if (start > path.length()) return;
        char c = S.charAt(start);
        path.append(c);
        backTrace(res, S, path, start+1);
        path.deleteCharAt(path.length()-1);
        if (Character.isLetter(c)) {
            if (Character.isLowerCase(c)) {
                path.append(Character.toUpperCase(c));
            }
            else {
                path.append(Character.toLowerCase(c));
            }
            backTrace(res, S, path, start+1);
            path.deleteCharAt(path.length()-1);
        }
    }

    public static void main(String[] args) {
        String s = "a1b2";
        LetterCasePermutation2 letterCasePermutation = new LetterCasePermutation2();
        List<String> list = letterCasePermutation.letterCasePermutation(s);
        System.out.println(list);
    }
}
