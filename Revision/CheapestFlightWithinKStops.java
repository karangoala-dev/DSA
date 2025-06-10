package Revision;

import Revision.utils.*;
import java.util.*;

public class CheapestFlightWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, List<Pair>> adj = new HashMap<>();
        for(int[] curr: flights){
            if(!adj.containsKey(curr[0])){
                adj.put(curr[0], new ArrayList<>());
            }
            adj.get(curr[0]).add(new Pair(curr[1], curr[2]));
        }

        //queue stores a trio, which is node, current cost and current stops
        Queue<Trio> q = new LinkedList<>();
        q.add(new Trio(src, 0, 0));
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        while(!q.isEmpty()){
            Trio curr = q.poll();
            if(curr.third <= k){
                List<Pair> neis = adj.get(curr.first);
                if(neis != null){
                    for(Pair nei: neis){
                        //if going through current to neighbour is better than what was computed earlier, only then proceed
                        if(curr.second + nei.second < cost[nei.first]){
                            q.add(new Trio(nei.first, curr.second + nei.second, curr.third + 1));
                            cost[nei.first] = curr.second + nei.second;
                        }
                    }
                }
            }
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
    public static void main(String[] args) {

    }
}
