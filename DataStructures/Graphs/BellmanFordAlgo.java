package DataStructures.Graphs;

import java.util.Arrays;

public class BellmanFordAlgo {
    static int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e8);
        dist[src] = 0;

        for(int i = 0; i < V; i++){
            for(int[] currentEdge: edges){
                int u = currentEdge[0];
                int v = currentEdge[1];
                int w = currentEdge[2];

                if(dist[u] != (int) 1e8){
                    if(dist[u] + w < dist[v]){
                        dist[v] = dist[u] + w;
                    }
                }
            }
        }

        //This below block added to handle negative cycle, for negative cycle we do one more single relaxation
        for(int[] currentEdge: edges){
            int u = currentEdge[0];
            int v = currentEdge[1];
            int w = currentEdge[2];

            if(dist[u] != (int) 1e8){
                if(dist[u] + w < dist[v]){
                    int[] temp = {-1};
                    return temp;
                }
            }
        }

        return dist;
    }
    public static void main(String[] args) {

    }
}
