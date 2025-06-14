package Revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PathWithMaximumProbability {
    private static class Node{
        int node;
        double prob;
        public Node(int _n, double _p){
            this.node = _n;
            this.prob = _p;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Node>> adj = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0], v = edges[i][1];
            adj.get(u).add(new Node(v, succProb[i]));
            adj.get(v).add(new Node(u, succProb[i]));
        }

        //pq to store node, and sort according to larger prob value on top, this will store the next node and prob so far
        double[] prob = new double[n];
        Arrays.fill(prob, Integer.MIN_VALUE);
        prob[start_node] = 1;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o2.prob, o1.prob));
        pq.add(new Node(start_node, 1.0));
        while (!pq.isEmpty()){
            Node curr = pq.poll();
            if(curr.node == end_node){
                return curr.prob;
            }
            List<Node> neis = adj.get(curr.node);
            for(Node nei: neis){
                if(prob[nei.node] < nei.prob * curr.prob){
                    pq.add(new Node(nei.node, nei.prob * curr.prob));
                }
            }
        }
        return prob[end_node];
    }
    public static void main(String[] args) {

    }
}
