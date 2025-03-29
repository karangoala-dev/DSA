package DataStructures.Graphs;

import java.util.Arrays;

public class NetworkDelay_BellmanFord {
    public int networkDelayTime(int[][] times, int n, int k) {
        //Find time taken to reach all nodes and return max of all the time taken
        int[] time = new int[n];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[k - 1] = 0;

        //For bellman ford, we need V - 1 no of relaxation
        for(int i = 0; i < n - 1; i++){
            for(int[] edge: times){
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if(time[u] != Integer.MAX_VALUE){
                    if(time[u] + w < time[v]){
                        time[v] = time[u] + w;
                    }
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for(int t: time){
            if(t == Integer.MAX_VALUE)
                return -1;
            res = Math.max(res, t);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
