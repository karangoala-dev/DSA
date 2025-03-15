package DataStructures.Graphs;

import java.util.*;

class _Pair{
    int v;
    int d;
    _Pair(int _v, int _d){
        this.v = _v;
        this.d = _d;
    }
}

public class ShortestPathFromSourceUndirectedGraph {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int[] dist = new int[adj.size()];
        Arrays.fill(dist, 100001);

        Queue<_Pair> q = new LinkedList<>();
        q.add(new _Pair(src, 0));

        int[] visited = new int[adj.size()];

        while(!q.isEmpty()){
            _Pair curr = q.poll();
            visited[curr.v] = 1;
            ArrayList<Integer> neigh = adj.get(curr.v);
            for(int node: neigh){
                if(visited[node] == 0){
                    int newDist = curr.d + 1;
                    q.add(new _Pair(node, newDist));
                }
            }
            dist[curr.v] = Math.min(dist[curr.v], curr.d);
        }
        for(int i = 0; i < dist.length; i++){
            if(dist[i] == 100001){
                dist[i] = -1;
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = 9; // Number of nodes

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges (undirected)
        int[][] edges = {
                {1, 3}, {0, 2}, {1, 6}, {0, 4}, {3, 5}, {4, 6}, {2, 5, 7, 8}, {6, 8}, {7, 6}
        };

        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                adj.get(i).add(edges[i][j]);
            }
        }

        int src = 0; // Source node
        ShortestPathFromSourceUndirectedGraph sp = new ShortestPathFromSourceUndirectedGraph();
        int[] result = sp.shortestPath(adj, src);

        // Print output
        System.out.println(Arrays.toString(result));
    }
}
