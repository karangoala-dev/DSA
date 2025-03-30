package DataStructures.Graphs;

import java.util.Arrays;

public class CheapestFlightsWithinKStops_BellmanFord {
    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            int[] cost = new int[n];
            Arrays.fill(cost, Integer.MAX_VALUE);
            cost[src] = 0;
            for(int i = 0; i < k + 1; i++){
                //Here temp contains current BFS layer computations i.e results for i-th stops in between
                int[] temp = cost.clone();
                for(int[] edge: flights){
                    int u = edge[0];
                    int v = edge[1];
                    int wt = edge[2];
                    //If cost till node u was computed in previous layer
                    if(cost[u] != Integer.MAX_VALUE){
                        //If cost till node u from previous iteration + weight is < current layer result of v
                        if(cost[u] + wt < temp[v]){
                            //update current layer result for v
                            temp[v] = cost[u] + wt;
                        }
                    }
                }
                cost = temp;
            }
            return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
        }
    }
    public static void main(String[] args) {

    }
}
