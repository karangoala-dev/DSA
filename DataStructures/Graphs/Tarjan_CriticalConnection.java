package DataStructures.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tarjan_CriticalConnection {
    List<List<Integer>> bridges = new ArrayList<>();
    int currentTime = 1;

    public void dfs(List<List<Integer>> adj, int[] time, int[] low, int[] vis, int node, int parent){
        vis[node] = 1;
        low[node] = currentTime;
        time[node] = currentTime;
        currentTime++;

        for(int nei: adj.get(node)){
            if(nei == parent){
                continue;
            }

            if(vis[nei] == 0){
                dfs(adj, time, low, vis, nei, node);
                low[node] = Math.min(low[nei], low[node]);
                //If low[nei] <= time[node] , ie we can reach the neighbour before or while visiting current node, so it is not a bridge,
                //but if low[nei] > time[node] means lowest time needed to reach neighbour is more than current time, so it is a bridge as this node needs to be visited to
                // reach neighbour
                if(low[nei] > time[node]){
                    bridges.add(Arrays.asList(node, nei));
                }
            }
            else{
                low[node] = Math.min(low[node], low[nei]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(List<Integer> connection: connections){
            int u = connection.get(0);
            int v = connection.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] vis = new int[n];
        int[] time = new int[n];
        int[] low = new int[n];

        dfs(adj, time, low, vis, 0, -1);

        return bridges;
    }
    public static void main(String[] args) {

    }
}
