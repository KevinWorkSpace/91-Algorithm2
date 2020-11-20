package HashTable.lecture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubdomainVisits {

    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0; i<cpdomains.length; i++) {
            String tmp = cpdomains[i];
            String[] strs = tmp.split(" ");
            int num = Integer.parseInt(strs[0]);
            String[] webs = strs[1].split("\\.");
            String s = "";
            for (int j=webs.length-1; j>=0; j--) {
                if (j == webs.length-1) s = webs[j];
                else s = webs[j] + "." + s;
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + num);
                }
                else {
                    map.put(s, num);
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (String key : map.keySet()) {
            int num = map.get(key);
            res.add(num + " " + key);
        }
        return res;
    }

    public static void main(String[] args) {
        SubdomainVisits subdomainVisits = new SubdomainVisits();
        String[] s = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> list = subdomainVisits.subdomainVisits(s);
    }
}
