package DataStructures.Graphs;

import java.util.*;

public class PathWithMaximumProbability {
    private static class Entity{
        int node;
        double prob;
        Entity(int _node, double _prob){
            this.node = _node;
            this.prob = _prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int src, int dst) {
        ArrayList<ArrayList<Entity>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        int i = 0;
        for(int[] edge: edges){
            adj.get(edge[0]).add(new Entity(edge[1], succProb[i]));
            adj.get(edge[1]).add(new Entity(edge[0], succProb[i]));
            i++;
        }

        PriorityQueue<Entity> pq = new PriorityQueue<>(Comparator.comparingDouble((Entity o) -> o.prob).reversed());
        double[] res = new double[n];
        pq.add(new Entity(src, 0));
        while(!pq.isEmpty()){
            Entity curr = pq.poll();
            ArrayList<Entity> neis = adj.get(curr.node);
            for(Entity nei: neis){
                double currProb = curr.node == src ? nei.prob : nei.prob * curr.prob;
                if(currProb > res[nei.node]){
                    res[nei.node] = currProb;
                    pq.add(new Entity(nei.node, currProb));
                }
            }
        }
        return res[dst];
    }

    public static void main(String[] args) {

    }
}
