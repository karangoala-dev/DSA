package DataStructures.Graphs;

import java.util.*;

public class CourseSchedule1_DFS {
    //This is a simple DFS based cycle detection. Not Toposort
    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: prerequisites){
            adj.get(edge[1]).add(edge[0]);
        }

        int[] visited = new int[n];
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                if(dfs(adj, i, visited)){
                    return false;
                }
            }
        }
        return true;
    }

    boolean dfs(ArrayList<ArrayList<Integer>> adj, int i, int[] vis){
        if(vis[i] == -1){
            return true;
        }
        if(vis[i] == 1){
            return false;
        }
        vis[i] = -1;
        for(int node: adj.get(i)){
            if(dfs(adj, node, vis)){
                return true;
            }
        }
        vis[i] = 1;
        return false;
    }
    public static void main(String[] args) {

    }
}
