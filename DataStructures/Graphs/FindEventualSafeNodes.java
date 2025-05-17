package DataStructures.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindEventualSafeNodes {
    //This approach takes O(N + E) time
    HashMap<Integer, Boolean> isSafe = new HashMap<>();
    public boolean dfs(int[][] graph, int node){
        if(isSafe.containsKey(node)){
            //means already visited and state is measured
            return isSafe.get(node);
        }
        //initially mark as false and traverse in DFS style
        isSafe.put(node, false);
        for(int nei: graph[node]){
            if(!dfs(graph, nei)){
                //if any of the outgoing edge is cyclic, return false;
                return false;
            }
        }
        //we reach here means, all neighbours traversed, mark node as safe now
        isSafe.put(node, true);

        //return safe status of this node
        return isSafe.get(node);
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            //traverse each node
            if(dfs(graph, i)){
                res.add(i);
            }
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
