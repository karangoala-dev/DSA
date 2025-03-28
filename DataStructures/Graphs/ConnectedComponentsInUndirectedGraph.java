package DataStructures.Graphs;

import java.util.*;

class DisjointSet{
    int[] parent;
    int[] rank;
    DisjointSet(int n){
        this.parent = new int[n];
        this.rank = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int findParent(int u){
        if(parent[u] == u){
            return u;
        }

        return parent[u] = findParent(parent[u]);
    }

    public void unionByRank(int u, int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

        if(ulp_u == ulp_v){
            return;
        }

        if(rank[ulp_u] < rank[ulp_v]){
            parent[ulp_u] = ulp_v;
        }
        else if(rank[ulp_v] < rank[ulp_u]){
            parent[ulp_v] = ulp_u;
        }
        else {
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }
}

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

    //Using union find
    public ArrayList<ArrayList<Integer>> connectedcomponents(int n, int[][] edges) {
        DisjointSet disjointSet = new DisjointSet(n);
        for(int[] edge: edges){
            disjointSet.unionByRank(edge[0], edge[1]);
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int root = disjointSet.findParent(i);
            if(map.containsKey(root)){
                map.get(root).add(i);
            }
            else{
                map.put(root, new ArrayList<>());
                map.get(root).add(i);
            }
        }

        for(Map.Entry<Integer, ArrayList<Integer>> entry: map.entrySet()){
            res.add(entry.getValue());
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
        soln.connectedcomponents(n, edges);
    }
}
