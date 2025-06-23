package Revision;

import Revision.utils.Pair;

import java.util.*;

public class GraphValidTree {
    HashSet<Integer> visited = new HashSet<>();
    public boolean bfs(List<List<Integer>> adj, int node){
        Queue<Pair> q = new LinkedList<>();
        //store node and previous in queue
        q.add(new Pair(node, -1));
        visited.add(node);
        while (!q.isEmpty()){
            Pair curr = q.poll();
            List<Integer> neis = adj.get(curr.first);
            for(int nei: neis){
                if(nei == curr.second){
                    continue;
                }
                if(visited.contains(nei)){
                    return false;
                }
                visited.add(nei);
                q.add(new Pair(nei, curr.first));
            }
        }

        return true;
    }
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        if(!bfs(adj, 0) || visited.size() != n){
            return false;
        }

        return true;
    }
    public static void main(String[] args) {
        GraphValidTree graphValidTree = new GraphValidTree();
        int n = 4;
        int[][] edges = {
                {0, 1},
                {2, 3}
        };
        System.out.println(graphValidTree.validTree(n, edges));
    }
}
