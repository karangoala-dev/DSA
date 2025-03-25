package DataStructures.Graphs;

import java.util.*;

public class TopologicalSortDFS {
    static Stack<Integer> st = new Stack<>();
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int[] visited, int node){
        visited[node] = 1;
        ArrayList<Integer> neigh = adj.get(node);
        for(int num: neigh){
            if(visited[num] == 0){
                dfs(adj, visited, num);
            }
        }
        st.push(node);
    }
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        int[] visited = new int[n];
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                dfs(adj, visited, i);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while(!st.isEmpty()){
            res.add(st.pop());
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
