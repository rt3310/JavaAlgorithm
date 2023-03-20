package structure.tree.trie;

public class App {

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("car");
        trie.insert("cb");
        trie.insert("do");
        trie.insert("dog");

        System.out.println(trie.search("car"));
        System.out.println(trie.search("ca"));
        System.out.println(trie.search("cb"));
        System.out.println(trie.search("do"));
        System.out.println(trie.search("dog"));
    }
}
