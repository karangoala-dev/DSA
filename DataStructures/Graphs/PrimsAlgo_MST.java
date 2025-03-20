package DataStructures.Graphs;

import java.util.*;

class PrimPair{
    int node;
    int distance;
    PrimPair(int _node, int _distance){
        this.node = _node;
        this.distance = _distance;
    }
}

public class PrimsAlgo_MST {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        int[] visited = new int[V];
        PriorityQueue<PrimPair> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
        pq.add(new PrimPair(0, 0));
        int sum = 0;
        while(!pq.isEmpty()){
            PrimPair current = pq.poll();
            int wt = current.distance;
            int node = current.node;

            if(visited[node] == 1){
                continue;
            }
            visited[node] = 1;
            sum += wt;

            List<int[]> neighbours = adj.get(node);
            for(int i = 0; i < neighbours.size(); i++){
                int[] neighbourNode = neighbours.get(i);
                int nNode = neighbourNode[0];
                int nWt = neighbourNode[1];

                if(visited[nNode] == 0){
                    pq.add(new PrimPair(nNode, nWt));
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {

    }
}
