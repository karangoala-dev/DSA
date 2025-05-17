package DataStructures.Graphs;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeNodes {
    //state array stores
    //0 -> unvisited
    //1 -> visited
    //2 -> safe
    public boolean dfs(int[][] graph, int node, int[] state){
        if(state[node] == 1){
            //if node was visited earlier
            return false;
        }
        if(state[node] == 2){
            //safe node so return true;
            return true;
        }
        //mark as visited
        state[node] = 1;

        //do dfs for each neighbour
        for(int nei: graph[node]){
            if(dfs(graph, nei, state) == false){
                // means cycle detected
                return false;
            }
        }

        //if we reach here means none of the neighbours have a cycle
        state[node] = 2;

        return true;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        int n = graph.length;
        int[] outdegree = new int[n];
        for(int i = 0; i < n; i++){
            outdegree[i] = graph[i].length;
            if(outdegree[i] == 0){
                result.add(i);
            }
        }

        for(int i = 0; i < n; i++){
            if(outdegree[i] != 0){
                //now do dfs, if outdegree is 0, node is already added to res
                if(dfs(graph, i, new int[n])){
                    result.add(i);
                }
            }
        }

        return result.stream().sorted().toList();
    }
    public static void main(String[] args) {

    }
}
