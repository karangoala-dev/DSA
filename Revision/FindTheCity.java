package Revision;

import Revision.utils.Pair;

import java.util.*;

public class FindTheCity {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Pair>> adj = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            //add edge for both directions
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o1.second - o2.second);
        int[][] distance = new int[n][n];
        for(int[] curr: distance){
            Arrays.fill(curr, Integer.MAX_VALUE);
        }

        for(int i = 0; i < n; i++){
            pq.add(new Pair(i, 0));
            distance[i][i] = 0;
            while (!pq.isEmpty()){
                Pair curr = pq.poll();
                //if curr from i in q is already larger than what we already have, no need to continue here
                if(curr.second > distance[i][curr.first]){
                    continue;
                }

                List<Pair> neis = adj.get(curr.first);
                for(Pair nei: neis){
                    if(distance[i][nei.first] > curr.second + nei.second){
                        distance[i][nei.first] = curr.second + nei.second;
                        pq.add(new Pair(nei.first, curr.second + nei.second));
                    }
                }
            }
            pq.clear();
        }

        int min = Integer.MAX_VALUE, res = -1;
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(distance[i][j] <= distanceThreshold){
                    count++;
                }
            }
            System.out.println(i + "->" + count);
            if(count <= min){
                min = count;
                res = i;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        FindTheCity findTheCity = new FindTheCity();
        int[][] arr = {
                {0, 1, 2},
                {0, 4, 8},
                {1, 2, 3},
                {1, 4, 2},
                {2, 3, 1},
                {3, 4, 1}
        };
        System.out.println(findTheCity.findTheCity(5, arr, 2));
    }
}
