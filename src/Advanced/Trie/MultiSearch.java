package Advanced.Trie;

import java.util.ArrayList;
import java.util.List;

public class MultiSearch {

    private TrieNode root = new TrieNode('/');

    public int[][] multiSearch(String big, String[] smalls) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i=0; i<smalls.length; i++) {
            list.add(new ArrayList<>());
            insert(smalls[i], i);
        }
        for (int i=0; i<big.length(); i++) {
            List<Integer> list1 = new ArrayList<>();
            search(list1, big.substring(i));
            for (int k : list1) {
                list.get(k).add(i);
            }
        }
        int[][] res = new int[list.size()][];
        for (int i=0; i<list.size(); i++) {
            res[i] = new int[list.get(i).size()];
            for (int j=0; j<list.get(i).size(); j++) {
                res[i][j] = list.get(i).get(j);
            }
        }
        return res;
    }

    public void insert(String word, int j) {
        TrieNode node = root;
        for (int i=0; i<word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                TrieNode newNode = new TrieNode(word.charAt(i));
                node.children[index] = newNode;
            }
            node = node.children[index];
        }
        node.isEndingChar = true;
        node.v = j;
    }

    /** Returns if the word is in the trie. */
    public void search(List<Integer> list, String word) {
        TrieNode node = root;
        for (int i=0; i<word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                return;
            }
            else {
                node = node.children[index];
                if (node.isEndingChar) {
                    list.add(node.v);
                }
            }
        }

    }

    public static void main(String[] args) {
        MultiSearch search = new MultiSearch();
        String big = "mississippi";
        String[] smalls = {"is","ppi","hi","sis","i","ssippi"};
        int[][] res = search.multiSearch(big, smalls);
    }

}


