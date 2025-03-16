package DataStructures.Graphs;

import java.util.*;

public class CheapestFlightsWithinKStops {
    //This class visible only to current file(Cant be defined outside the main class of this file)
    private static class Triad{
        int node;
        int cost;
        int stops;
        Triad(int _n, int _d, int _s){
            this.node = _n;
            this.cost = _d;
            this.stops = _s;
        }
    }

    private static class Duo{
        int node;
        int cost;
        Duo(int _n, int _d){
            this.node = _n;
            this.cost = _d;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //Here cheapest flight is needed, so we are minimising the cost and not distance
        ArrayList<ArrayList<Duo>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] curr: flights){
            adj.get(curr[0]).add(new Duo(curr[1], curr[2]));
        }

        int cost[] = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);

        // Here, we use a queue instead of a priority queue because we need to process paths in order of stops (like BFS).
        // If we used a priority queue, a cheaper but higher-stop path might be processed first, preventing a valid K-stop path from being considered.
        // A queue ensures we explore all possible paths up to K stops before deciding the cheapest one.
        Queue<Triad> q = new LinkedList<>();
        q.add(new Triad(src, 0, 0));

        while(!q.isEmpty()){
            Triad current = q.poll();
            //equal is allowed because we need to update the location on kth stop
            if(current.stops <= k){
                ArrayList<Duo> neighbours = adj.get(current.node);
                for(Duo node: neighbours){
                    if(current.cost + node.cost < cost[node.node]){
                        q.add(new Triad(node.node, current.cost + node.cost, current.stops + 1));
                        cost[node.node] = current.cost + node.cost;
                    }
                }
            }
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
    public static void main(String[] args) {

    }
}
