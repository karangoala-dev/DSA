package DataStructures.Graphs;

import java.util.*;

public class NoOfWaysToArriveAtDestination {
    private static class Node{
        int node;
        long dist;
        Node(int _n, long _d){
            this.node = _n;
            this.dist = _d;
        }
    }

    public int countPaths(int n, int[][] roads) {
        List<List<Node>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] curr: roads){
            adj.get(curr[0]).add(new Node(curr[1], curr[2]));
            adj.get(curr[1]).add(new Node(curr[0], curr[2]));
        }
        //minHeap stores the node and distance
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.dist, o2.dist));
        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(ways, 0);

        pq.add(new Node(0, 0));
        dist[0] = 0;
        ways[0] = 1;
        int MOD = (int) (1e9 + 7);

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            List<Node> neighbours = adj.get(curr.node);
            for(Node nei: neighbours){
                long distance = (1L * curr.dist) + nei.dist;
                if(distance < dist[nei.node]){
                    //we found a better distance to reach nei, so reset the ways to same as ways[curr] and continue bfs
                    pq.add(new Node(nei.node, distance));
                    dist[nei.node] = distance;
                    ways[nei.node] = ways[curr.node] % MOD;
                }
                else if(distance == dist[nei.node]){
                    //if we found same distance then just add the ways
                    ways[nei.node] = (ways[nei.node] + ways[curr.node]) % MOD;
                }
            }
        }
        return ways[n - 1] % MOD;
    }
    public static void main(String[] args){

    }
}
