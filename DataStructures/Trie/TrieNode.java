package DataStructures.Trie;

import java.util.HashMap;

public class TrieNode {
    public HashMap<Character, TrieNode> children;
    public boolean isEndOfWord;

    public TrieNode(boolean flag){
        this.children = new HashMap<>();
        this.isEndOfWord = flag;
    }
}
