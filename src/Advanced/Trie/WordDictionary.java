package Advanced.Trie;

import javafx.beans.value.WritableFloatValue;

public class WordDictionary {

    TrieNode root = new TrieNode('/');

    /** Initialize your data structure here. */
    public WordDictionary() {

    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
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
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i=0; i<word.length(); i++) {
            if (word.charAt(i) == '.') {
                boolean flag = true;
                boolean f = true;
                for (int j=0; j<26; j++) {
                    if (node.children[j] != null) {
                        f = false;
                        boolean res = search(word.substring(0, i) + node.children[j] + word.substring(i+1));
                        if (res) flag = false;
                    }
                }
                if (f) return false;
                return !flag;
            }
            else {
                int index = word.charAt(i) - 'a';
                System.out.println(word.charAt(i));
                if (node.children[index] == null) {
                    return false;
                }
                node = node.children[index];
            }
        }
        return node.isEndingChar;
    }

    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();
        String[] strings = {"WordDictionary","addWord","addWord","addWord","search","search","search","search"};
        for (int i=0; i<strings.length; i++) {
            dictionary.addWord(strings[i]);
        }
        String[] s2 = {"bad","dad","mad","pad","bad",".ad","b.."};
        for (int i=0; i<s2.length; i++) {
            dictionary.search(s2[i]);
        }
    }
}
