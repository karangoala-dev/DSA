package DataStructures.Graphs;

import java.util.*;

public class NetworkDelayDjikstra {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] time = new int[n];
        Arrays.fill(time, Integer.MAX_VALUE);

        ArrayList<ArrayList<iPair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] curr : times) {
            adj.get(curr[0] - 1).add(new iPair(curr[1] - 1, curr[2]));
        }

        PriorityQueue<iPair> pq = new PriorityQueue<>((o1, o2) -> o1.second - o2.second);
        pq.add(new iPair(k - 1, 0));
        time[k - 1] = 0;

        while (!pq.isEmpty()) {
            iPair currentNode = pq.poll();
            ArrayList<iPair> neigh = adj.get(currentNode.first);
            for(iPair node: neigh){
                if(time[node.first] > currentNode.second + node.second){
                    //Means we got a quicker timee
                    pq.add(new iPair(node.first, currentNode.second + node.second));
                    time[node.first] = currentNode.second + node.second;
                }
            }
        }

        int res = Integer.MIN_VALUE;
        for (int num : time) {
            if(num != Integer.MAX_VALUE){
                res = Math.max(num, res);
            }
            else{
                return -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
