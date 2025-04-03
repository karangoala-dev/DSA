package DataStructures.Graphs;

import java.util.*;

public class CityWithSmallestNeighboursThresholdDIstance {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }

        for(int via = 0; via < n; via++){
            for(int u = 0; u < n; u++){
                for(int v = 0; v < n; v++){
                    if(dist[u][via] != Integer.MAX_VALUE && dist[via][v] != Integer.MAX_VALUE){
                        dist[u][v] = Math.min(dist[u][v], dist[u][via] + dist[via][v]);
                        dist[v][u] = Math.min(dist[v][u], dist[v][via] + dist[via][u]);
                    }
                }
            }
        }

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)->{
            if(map.get(o1).size() != map.get(o2).size()){
                //return smaller size list wala item
                return Integer.compare(map.get(o1).size(), map.get(o2).size());
            }
            else{
                //else return the larger value item
                return Integer.compare(o2, o1);
            }
        });
        for(int u = 0; u < n; u++){
            for(int v = 0; v < n; v++){
                if(u != v){
                    //since we need to also consider disconnected nodes. Add a list for all of the nodes, despite the threshold.
                    //Since pq is dependednt on map's list values;
                    map.putIfAbsent(u, new ArrayList<>());
                    map.putIfAbsent(v, new ArrayList<>());
                    if(dist[u][v] <= distanceThreshold){
                        map.get(u).add(u);
                        map.get(v).add(u);
                    }
                }
            }
        }
        //Finally add each item to priority queue
        for(int i = 0; i < n; i++){
            pq.add(i);
        }
        //Topmost city will have the required properties
        return pq.poll();
    }
    public static void main(String[] args) {

    }
}
