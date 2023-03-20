package structure.tree.trie;

import java.util.HashMap;
import java.util.Map;

public class Node {
    private final Map<Character, Node> children;
    private boolean endOfWord;

    public Node() {
        children = new HashMap<>();
    }

    public Map<Character, Node> getChildren() {
        return children;
    }

    public boolean isEndOfWord() {
        return endOfWord;
    }

    public void endOfWordToTrue() {
        this.endOfWord = true;
    }
}
