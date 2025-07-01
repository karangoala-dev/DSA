package Revision;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int m = beginWord.length();
        HashMap<String, List<String>> graph = new HashMap<>();
        wordList.add(beginWord);
        for(String word: wordList){
            StringBuilder sb = new StringBuilder(word);
            for (int i = 0; i < m; i++){
                sb.setCharAt(i, '*');
                String pattern = sb.toString();
                if(!graph.containsKey(pattern)){
                    graph.put(pattern, new ArrayList<>());
                }
                graph.get(pattern).add(word);
                sb.setCharAt(i, word.charAt(i));
            }
        }

        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.add(beginWord);
        visited.add(beginWord);
        int moves = 0;
        boolean flag = false;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String curr = q.poll();
                if(curr.equals(endWord)){
                    return moves + 1;
                }
                for (int j = 0; j < m; j++){
                    StringBuilder sb = new StringBuilder(curr);
                    sb.setCharAt(j, '*');
                    List<String> neis = graph.get(sb.toString());
                    for(String nei: neis){
                        if(visited.contains(nei)){
                            continue;
                        }
                        q.add(nei);
                        visited.add(nei);
                    }
                }
            }
            moves++;
        }
        return 0;
    }
    public static void main(String[] args) {

    }
}
