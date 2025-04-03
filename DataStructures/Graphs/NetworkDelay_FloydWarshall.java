package DataStructures.Graphs;

import java.util.*;

public class NetworkDelay_FloydWarshall {
    public int networkDelayTime(int[][] edges, int n, int k) {
        int[][] times = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(times[i], Integer.MAX_VALUE);
        }
        for(int[] edge: edges){
            int r = edge[0] - 1;
            int c = edge[1] - 1;
            int w = edge[2];
            times[r][c] = w;
        }
        for(int i = 0; i < n; i++){
            times[i][i] = 0;
        }

        for(int i = 0; i < n; i++){
            for(int u = 0; u < n; u++){
                for(int v = 0; v < n; v++){
                    if(times[u][i] < Integer.MAX_VALUE && times[i][v] < Integer.MAX_VALUE){
                        times[u][v] = Math.min(times[u][i] + times[i][v], times[u][v]);
                    }
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(times[k - 1][i] == Integer.MAX_VALUE){
                return -1;
            }
            res = Math.max(res, times[k - 1][i]);
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
