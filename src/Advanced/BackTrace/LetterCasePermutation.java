package Advanced.BackTrace;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

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
        for (int i=start; i<S.length(); i++) {
            if (i > path.length()) {
                return;
            }
            char c = S.charAt(i);
            path.append(S.charAt(i));
            backTrace(res, S, path, i+1);
            path.deleteCharAt(path.length()-1);
            if (Character.isLetter(c)) {
                if (Character.isLowerCase(c)) {
                    path.append(Character.toUpperCase(c));
                }
                else {
                    path.append(Character.toLowerCase(c));
                }
                backTrace(res, S, path, i+1);
                path.deleteCharAt(path.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "A1b2";
        LetterCasePermutation letterCasePermutation = new LetterCasePermutation();
        List<String> list = letterCasePermutation.letterCasePermutation(s);
        System.out.println(list);
    }
}
