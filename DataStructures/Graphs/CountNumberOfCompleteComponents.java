package DataStructures.Graphs;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfCompleteComponents {
    private static class DisjointSet{
        int[] parent;
        int[] rank;
        DisjointSet(int n){
            this.parent = new int[n + 1];
            this.rank = new int[n + 1];
            for(int i = 0; i <= n; i++){
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
    private static class Pair{
        int nodes;
        int edges;
        Pair(int _n, int _e){
            this.nodes = _n;
            this.edges = _e;
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        DisjointSet disjointSet = new DisjointSet(n);
        for(int[] edge: edges){
            disjointSet.unionByRank(edge[0], edge[1]);
        }
        int[] parent = new int[n];
        int[] nodeCount = new int[n];
        HashMap<Integer, Pair> parentVsCount = new HashMap<>();
        for(int i = 0; i < n; i++){
            //Path compression
            parent[i] = disjointSet.findParent(i);
            //Setting initial edge count to 0 for all parent nodes and updating node count
            if(!parentVsCount.containsKey(parent[i])){
                parentVsCount.put(parent[i], new Pair(0, 0));
            }
            parentVsCount.put(parent[i], new Pair(parentVsCount.get(parent[i]).nodes + 1,0));
        }

        //update edge count
        for(int[] edge: edges){
            int p = parent[edge[0]];
            parentVsCount.put(p, new Pair(parentVsCount.get(p).nodes, parentVsCount.get(p).edges + 1));
        }

        int res = 0;
        for(Map.Entry<Integer, Pair> entry: parentVsCount.entrySet()){
            int nodes = entry.getValue().nodes, e = entry.getValue().edges;

            if(e == (nodes * (nodes - 1)) / 2){
                res++;
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
