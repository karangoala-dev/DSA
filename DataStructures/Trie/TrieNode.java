package DataStructures.Trie;

import java.util.HashMap;

public class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isEndOfWord;
}
