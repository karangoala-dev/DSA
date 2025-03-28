package DataStructures.Graphs;

import java.util.*;

public class ConnectedComponentsInUndirectedGraph {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj, int[] vis, int node, ArrayList<Integer> path){
        vis[node] = 1;
        for(int neighbour: adj.get(node)){
            if(vis[neighbour] == 0){
                dfs(adj, vis, neighbour, path);
            }
        }
        path.add(node);
        return path;
    }

    public ArrayList<ArrayList<Integer>> connectedcomponents_UsingDFS(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] vis = new int[n];

        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                ArrayList<Integer> arr = new ArrayList<>();
                res.add(dfs(adj, vis, i, arr));

            }
        }
        return res;
    }

    public static void main(String[] args) {
        ConnectedComponentsInUndirectedGraph soln = new ConnectedComponentsInUndirectedGraph();
        int n = 5;
        int[][] edges = {{0, 1},{2, 1},{3, 4}};
        ArrayList<ArrayList<Integer>> res = soln.connectedcomponents_UsingDFS(n, edges);
        for(ArrayList<Integer> curr: res){
            for(int a: curr){
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
