package DataStructures.Graphs;

import java.util.*;

public class MinimumCostToReachDestination {
    //This class visible only to current file(Cant be defined outside the main class of this file)
    private static class Triad{
        int node;
        int cost;
        int time;
        Triad(int _n, int _c, int _t){
            this.node = _n;
            this.cost = _c;
            this.time = _t;
        }
    }

    private static class Duo{
        int node;
        int time;
        Duo(int _n, int _t){
            this.node = _n;
            this.time = _t;
        }
    }

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        ArrayList<ArrayList<Duo>> adj = new ArrayList<>();
        int n = passingFees.length;
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] curr: edges){
            adj.get(curr[0]).add(new Duo(curr[1], curr[2]));
            adj.get(curr[1]).add(new Duo(curr[0], curr[2]));
        }

        Queue<Triad> q = new LinkedList<>();
        q.add(new Triad(0, passingFees[0], 0));
        int cost[] = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        while(!q.isEmpty()){
            Triad current = q.poll();
            if(current.time < maxTime){
                System.out.println("current time: " + current.time);
                ArrayList<Duo> neighbours = adj.get(current.node);
                for(Duo node: neighbours){
                    if(current.cost + passingFees[node.node] < cost[node.node] && current.time + node.time <= maxTime){
                        q.add(new Triad(node.node, passingFees[node.node] + current.cost, node.time + current.time));
                        cost[node.node] = current.cost + passingFees[node.node];
                    }
                }
            }
        }
        return cost[n - 1] == Integer.MAX_VALUE ? -1 : cost[n - 1];
    }
    public static void main(String[] args) {
        MinimumCostToReachDestination minimumCostToReachDestination = new MinimumCostToReachDestination();
        int[][] edges = {{0,1,10},{1,2,10},{2,5,10},{0,3,1},{3,4,10},{4,5,15}};
        int[] fees = {5,1,2,20,20,3};
        System.out.println(minimumCostToReachDestination.minCost(30, edges, fees));
    }
}
