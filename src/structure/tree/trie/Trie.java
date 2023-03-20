package structure.tree.trie;

public class Trie {
    private final Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String str) {
        Node curNode = this.root;

        char[] chars = str.toCharArray();
        for (char c : chars) {
            curNode = curNode.getChildren().computeIfAbsent(c, key -> new Node());
        }
        curNode.endOfWordToTrue();
    }

    public boolean search(String str) {
        Node curNode = this.root;

        char[] chars = str.toCharArray();
        for (char c : chars) {
            curNode = curNode.getChildren().get(c);
            if (curNode == null) {
                return false;
            }
        }
        return curNode.isEndOfWord();
    }
}
