package Advanced.Trie;

public class Trie {

    private TrieNode root = new TrieNode('/');

    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
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

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i=0; i<word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                return false;
            }
            else node = node.children[index];
        }
        return node.isEndingChar;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i=0; i<prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.children[index] == null) {
                return false;
            }
            else node = node.children[index];
        }
        return true;
    }
}

class TrieNode {
    char val;
    TrieNode[] children = new TrieNode[26];
    boolean isEndingChar;

    public TrieNode(char val) {
        this.val = val;
    }
}
