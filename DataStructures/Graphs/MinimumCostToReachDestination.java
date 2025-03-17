package DataStructures.Graphs;

import java.util.*;

public class MinimumCostToReachDestination {
    //This class visible only to current file(Cant be defined outside the main class of this file)
    //INCOMPLETE**********************************
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

        PriorityQueue<Triad> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        q.add(new Triad(0, passingFees[0], 0));
        int minTime[] = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        while(!q.isEmpty()){
            Triad current = q.poll();
            if(current.time >= maxTime)
                continue;
//            if(current.time < maxTime){
//                System.out.println("current time: " + current.time);
                minTime[current.node] = current.time;
                if(current.node == n - 1){
                    return minTime[current.node];
                }
                ArrayList<Duo> neighbours = adj.get(current.node);
                for(Duo node: neighbours){
                    int time = current.time + node.time;
                    int cost = current.cost + passingFees[node.node];
                    if(time > maxTime || time > minTime[node.node]){
                        continue;
                    }
                    q.add(new Triad(node.node, cost, time));
                }
//            }
        }
        return -1;
    }
    public static void main(String[] args) {
        MinimumCostToReachDestination minimumCostToReachDestination = new MinimumCostToReachDestination();
        int[][] edges = {
                {0, 1, 10},
                {1, 2, 10},
                {0, 2, 15}
        };
        int[] passingFees = {5, 1, 2};
        System.out.println(minimumCostToReachDestination.minCost(25, edges, passingFees));
    }
}
