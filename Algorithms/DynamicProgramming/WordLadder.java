package Algorithms.DynamicProgramming;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> graph= new HashMap<>();
        int m = beginWord.length();
        //generate the graph using pattern as key
        for(String word: wordList){
            for(int i = 0; i < m; i++){
                StringBuilder sb = new StringBuilder(word);
                sb.setCharAt(i, '*');
                if(!graph.containsKey(sb.toString())){
                    graph.put(sb.toString(), new ArrayList<>());
                }
                graph.get(sb.toString()).add(word);
            }
        }
        System.out.println(graph);
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        visited.add(beginWord);
        int moves = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int j = 0; j < size; j++){
                String curr = q.poll();
                if(curr.equals(endWord)){
                    //count endWord too
                    return moves + 1;
                }
                //check for all patterns in this string
                for(int i = 0; i < m; i++){
                    StringBuilder sb = new StringBuilder(curr);
                    sb.setCharAt(i, '*');
                    String pattern = sb.toString();
                    if(graph.containsKey(pattern)){
                        for(String nei: graph.get(pattern)){
                            if(!visited.contains(nei)){
                                q.add(nei);
                                visited.add(nei);
                            }
                        }
                    }
                }
            }
            moves++;
        }
        return 0;
    }
    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        System.out.println(wordLadder.ladderLength("hit", "cog", new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"))));
    }
}
