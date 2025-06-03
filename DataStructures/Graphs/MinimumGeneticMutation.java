package DataStructures.Graphs;

import java.util.*;

public class MinimumGeneticMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashMap<String, List<String>> graph = new HashMap<>();
        //generate the graph using pattern as key
        for(String word: bank){
            for(int i = 0; i < 8; i++){
                StringBuilder sb = new StringBuilder(word);
                sb.setCharAt(i, '*');
                if(!graph.containsKey(sb.toString())){
                    graph.put(sb.toString(), new ArrayList<>());
                }
                graph.get(sb.toString()).add(word);
            }
        }

        HashSet<String> visited = new HashSet<>();
        visited.add(startGene);
        Queue<String> q = new LinkedList<>();
        q.add(startGene);
        int moves = 0;
        while (!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String gene = q.poll();

                if(gene.equals(endGene)){
                    return moves;
                }
                for(int j = 0; j < 8; j++){
                    StringBuilder sb = new StringBuilder(gene);
                    sb.setCharAt(j, '*');
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

        return -1;
    }
    public static void main(String[] args) {

    }
}
