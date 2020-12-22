package Advanced.KMP;

public class StrStr2 {

    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;
        long sum = 0;
        for (int j=0; j<needle.length(); j++) {
            sum += (needle.charAt(j) - 'a');
        }
        long tmp = 0;
        for (int j=0; j<needle.length(); j++) {
            tmp += haystack.charAt(j) - 'a';
        }
        if (tmp == sum) {
            boolean f = true;
            for (int j=0; j<needle.length(); j++) {
                if (haystack.charAt(j) != needle.charAt(j)) {
                    f = false;
                }
            }
            if (f) return 0;
        };
        for (int i=1; i<=haystack.length()-needle.length(); i++) {
            tmp -= haystack.charAt(i-1) - 'a';
            tmp += haystack.charAt(needle.length()-1+i) - 'a';
            if (sum == tmp) {
                boolean f = true;
                for (int j=i; j<needle.length()+i; j++) {
                    if (haystack.charAt(j) != needle.charAt(j-i)) {
                        f = false;
                    }
                }
                if (f) return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String hay = "ababcaababcaabc";
        String needle = "ababcaabc";
        StrStr2 strStr = new StrStr2();
        System.out.println(strStr.strStr(hay, needle));
    }
}
