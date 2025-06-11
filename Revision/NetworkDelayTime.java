package Revision;

import Revision.utils.*;

import java.util.*;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: times){
            adj.get(edge[0] - 1).add(new Pair(edge[1] - 1, edge[2]));
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(k - 1, 0));
        int[] time = new int[n];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[k - 1] = 0;

        while(!q.isEmpty()){
            Pair curr = q.poll();

            ArrayList<Pair> neis  = adj.get(curr.first);
            for(Pair nei: neis){
                if(curr.second + nei.second < time[nei.first]){
                    q.add(new Pair(nei.first, curr.second + nei.second));
                    time[nei.first] = curr.second + nei.second;
                }
            }
        }

        int res = Integer.MIN_VALUE;
        for(int t: time){
            if(t == Integer.MAX_VALUE){
                //mean some node is still unvisited
                return -1;
            }
            res = Math.max(res, t);
        }
        return res;
    }
    public static void main(String[] args) {
        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        int[][] times = new int[][] {{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(networkDelayTime.networkDelayTime(times, 4, 2));
    }
}
