package Advanced.KMP;

public class StrStr {

    public int strStr(String haystack, String needle) {
        for (int i=0; i<=haystack.length()-needle.length(); i++) {
            boolean f = true;
            for (int j=0; j<needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    f = false;
                    break;
                }
            }
            if (f) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String hay = "asdf";
        String needle = "";
        StrStr strStr = new StrStr();
        System.out.println(strStr.strStr(hay, needle));
    }
}
