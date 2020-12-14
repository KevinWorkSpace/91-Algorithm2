package Advanced.Trie;

public class MapSum {

    private TrieNode root = new TrieNode('/');
    private int num = 0;

    /** Initialize your data structure here. */
    public MapSum() {

    }

    public void insert(String key, int val) {
        TrieNode node = root;
        for (int i=0; i<key.length(); i++) {
            char c = key.charAt(i);
            int index = c - 'a';
            if (node.children[index] == null) {
                TrieNode newNode = new TrieNode(c);
                node.children[index] = newNode;
            }
            node = node.children[index];
        }
        node.isEndingChar = true;
        node.v = val;
    }

    public int sum(String prefix) {
        TrieNode node = root;
        for (int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (node.children[index] == null) {
                return 0;
            }
            node = node.children[index];
        }
        num = 0;
        dfs(node);
        return num;
    }

    public void dfs(TrieNode node) {
        if (node == null) return;
        if (node.isEndingChar) {
            num += node.v;
        }
        for (int i=0; i<node.children.length; i++) {
            if (node.children[i] != null) {
                dfs(node.children[i]);
            }
        }
    }
}
