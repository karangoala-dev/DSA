package DataStructures.Graphs;

import java.util.*;

public class NegativeCycleDetection {
    public int isNegativeWeightCycle(int V, int[][] edges)
    {
        int[] dist = new int[V];
        // Since we don't have a fixed src, we mark all distances as 0 initially
        // This ensures that all nodes are considered equally for relaxation.
        // After V-1 iterations, if any distance is still decreasing in the V-th iteration,
        // it means we have a negative cycle in the graph.
        Arrays.fill(dist, 0);

        for(int i = 0; i < V - 1; i++){
            for(int[] currentEdge: edges){
                int u = currentEdge[0];
                int v = currentEdge[1];
                int w = currentEdge[2];


                if(dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                }

            }
        }

        //This below block added to handle negative cycle, for negative cycle we do one more single relaxation
        for(int[] currentEdge: edges){
            int u = currentEdge[0];
            int v = currentEdge[1];
            int w = currentEdge[2];


            if(dist[u] + w < dist[v]){
                int[] temp = {-1};
                return 1;
            }

        }

        return 0;
    }
    public static void main(String[] args) {

    }
}
