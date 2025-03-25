package DataStructures.Graphs;

import java.util.*;

public class MinimumHeightTrees {
    private static class Pair{
        int n;
        int height;
        Pair(int _n, int _height){
            this.n = _n;
            this.height = _height;
        }
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> heightVsNodes = new HashMap<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for(int i = 0; i < n; i++){
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(i, 0));
            int[] vis = new int[n];
            int height = Integer.MIN_VALUE;
            while(!q.isEmpty()){
                Pair curr = q.poll();
                vis[curr.n] = 1;
                ArrayList<Integer> neigh = adj.get(curr.n);
                for(int node: neigh){
                    if(vis[node] == 1){
                        height = Math.max(height, curr.height);
                    }
                    else {
                        q.add(new Pair(node, curr.height + 1));
                    }
                }
            }
            if(heightVsNodes.containsKey(height)){
                heightVsNodes.get(height).add(i);
            }
            else {
                heightVsNodes.put(height, new ArrayList<>(Arrays.asList(i)));
            }
        }
        int minKey = Collections.min(heightVsNodes.keySet());
        return heightVsNodes.get(minKey);
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
    }
}
