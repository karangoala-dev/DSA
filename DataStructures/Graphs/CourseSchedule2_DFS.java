package DataStructures.Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class CourseSchedule2_DFS {
    public int[] findOrder(int n, int[][] edges) {
        int[] res = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)  adj.add(new ArrayList<>());

        for(int[] edge: edges){
            adj.get(edge[1]).add(edge[0]);
        }
        int[] visited = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                if(dfs(adj, visited, i, st)){
                    return new int[0];
                }
            }
        }

        int index = 0;
        while(!st.isEmpty()){
            res[index++] = st.pop();
        }

        return res;
    }
    public static boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] visited, int node, Stack<Integer> st){
        if(visited[node] == -1){
            return true;
        }
        if(visited[node] == 1){
            return false;
        }

        visited[node] = -1;
        for(int n: adj.get(node)){
            if(dfs(adj, visited, n, st)){
                return true;
            }
        }
        visited[node] = 1;
        st.push(node);

        return false;
    }
    public static void main(String[] args) {

    }
}
