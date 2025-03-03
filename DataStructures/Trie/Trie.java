package DataStructures.Trie;

import java.util.*;

public class Trie {
    private TrieNode root;

    public Trie(){
        root = new TrieNode(false);
    }

    public void addWord(String word){
        TrieNode node = root;
        for(Character ch: word.toCharArray()){
            if(!node.children.containsKey(ch)){
                TrieNode newNode = new TrieNode(false);
                node.children.put(ch, newNode);
            }
            node = node.children.get(ch);
        }
        node.isEndOfWord = true;
    }

    public List<String> getResults(String prefix){
        List<String> res = new ArrayList<>();
        TrieNode node = root;
        int i = 0;

        while(i < prefix.length()){
            if(!node.children.containsKey(prefix.charAt(i))){
                return res;
            }
            node = node.children.get(prefix.charAt(i));
            i++;
        }
        //Now node is at last character of prefix
        for(Map.Entry<Character, TrieNode> entry: node.children.entrySet()){
            String current = "";
            TrieNode currentNode = entry.getValue();
//            while(currentNode.isEndOfWord == false){
//
//            }
        }
        return res;
    }
}
