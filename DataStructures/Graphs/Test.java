package DataStructures.Graphs;

import java.util.*;

public class Test {
    public static boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: prerequisites){
            adj.get(edge[1]).add(edge[0]);
        }

        Stack<Integer> st = new Stack<>();
        int[] visited = new int[n];
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                dfs(adj, i, visited, st);
            }
        }

        if(st.size() == n){
            return true;
        }
        return false;
    }

    static void dfs(ArrayList<ArrayList<Integer>> adj, int i, int[] vis, Stack<Integer> st){
        vis[i] = 1;
        for(int node: adj.get(i)){
            if(vis[node] == 0){
                dfs(adj, node, vis, st);
            }
        }
        st.push(i);
    }
    public static void main(String[] args) {
        int[][] edges = {{1,0},{0,1}};
        System.out.println(canFinish(2, edges));
    }
}
