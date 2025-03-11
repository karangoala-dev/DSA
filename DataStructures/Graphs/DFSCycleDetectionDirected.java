package DataStructures.Graphs;

import java.util.*;

public class DFSCycleDetectionDirected {
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int node, int[] visited, int[] pathVisited){
        visited[node] = 1;
        pathVisited[node] = 1;
        ArrayList<Integer> neighbours = adj.get(node);
        for(int num: neighbours){
            if(visited[num] == 0){
                if(dfs(adj, num, visited, pathVisited)){
                    return true;
                }
            }
            else if(visited[num] == 1 && pathVisited[num] == 1){
                return true;
            }
        }
        pathVisited[node] = 0;
        return false;
    }
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        int[] visited = new int[n];
        int[] pathVisited = new int[n];

        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                if(dfs(adj, i, visited, pathVisited)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
