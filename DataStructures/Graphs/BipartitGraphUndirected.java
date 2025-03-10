package DataStructures.Graphs;

import java.util.*;

public class BipartitGraphUndirected {
    public boolean bfs(int[][] graph, int start, int[] colored){
        int n = graph.length;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        colored[start] = 1;
        while(!q.isEmpty()){
            int current = q.poll();
            int[] neighbours = graph[current];
            for(int i = 0; i < neighbours.length; i++){
                //Is neighbour is already visited
                if(colored[neighbours[i]] != 0){
                    System.out.println("Hello");
                    if(colored[neighbours[i]] == colored[current]){
                        return false;
                    }
                }
                else{
                    //If neighbour is not visited
                    if(colored[current] == 1){
                        colored[neighbours[i]] = 2;
                    }
                    else if(colored[current] == 2){
                        colored[neighbours[i]] = 1;
                    }

                    q.add(neighbours[i]);
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colored = new int[n];
        boolean res = true;
        //This is done to check unconnected components. Since unconnected components are always bipartite, we need only one occurence of non-bipartite component
        //to deem whole graph as non-bipartite, so and operation is done.
        for(int i = 0; i < n; i++){
            if(colored[i] == 0){
                res = res && bfs(graph, i, colored);
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
