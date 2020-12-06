package Basic.Stack.lecture;

public class DecodeString2 {

    private int index;

    public String decodeString(String s) {
        index = 0;
        return analysis(s);
    }

    public String analysis(String s) {
        StringBuffer res = new StringBuffer();
        int multi = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                multi = multi * 10 + Character.getNumericValue(c);
            }
            else if (c == '[') {
                index ++;
                String tmp = analysis(s);
                for(int i=0; i<multi; i++) {
                    res.append(tmp);
                }
                multi = 0;
            }
            else if (c == ']') break;
            else res.append(c);
            index ++;
        }
        return res.toString();
    }
}
