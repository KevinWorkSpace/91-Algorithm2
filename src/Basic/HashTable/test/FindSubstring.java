package Basic.HashTable.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindSubstring {

    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0; i<words.length; i++) {
            int value = map.getOrDefault(words[i], 0);
            map.put(words[i], value+1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<=s.length() - words[0].length() * words.length; i++) {
            boolean flag = true;
            HashMap<String, Integer> map2 = new HashMap<>();
            for (int j=i; j<=i + words[0].length() * words.length - words[0].length(); j+=words[0].length()) {
                String str = s.substring(j, j + words[0].length());
                if (map.containsKey(str)) {
                    int value = map2.getOrDefault(str, 0);
                    map2.put(str, value+1);
                    if (map2.get(str) > map.get(str)) {
                        flag = false;
                        break;
                    }
                }
                else {
                    flag = false;
                    break;
                }
            }
            if (flag) list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        String str = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","word"};
        FindSubstring substring = new FindSubstring();
        List<Integer> list = substring.findSubstring(str, words);
    }
}
