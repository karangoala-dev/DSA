package DataStructures.Trie;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.addWord("car");
        trie.addWord("cat");
        trie.addWord("care");
        trie.addWord("cartoon");
        trie.addWord("dog");

        System.out.println(trie.getResults("ca"));
        // Output: [car, care, cat, cartoon]

        System.out.println(trie.getResults("car"));
        // Output: [car, care, cartoon]

        System.out.println(trie.getResults("d"));
        // Output: [dog]

        System.out.println(trie.getResults("z"));
        // Output: []
    }
}
