package DataStructures.Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class DjikstraPriorityQueue {
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(adj.size(), 100001));
        res.set(src, 0);
        //Min Heap
        PriorityQueue<iPair> pq = new PriorityQueue<>((o1, o2) -> o1.second - o2.second);
        pq.add(new iPair(src, 0));

        while(!pq.isEmpty()){
            iPair currentNode = pq.poll();
            ArrayList<iPair> neighbours = adj.get(currentNode.first);
            for(iPair node: neighbours){
                //Get current distance which is current node's distance from source + neighbour node's distance from current node(weight)
                int currentDistance = currentNode.second + node.second;
                //Shorter distance found, add to queue
                if(currentDistance < res.get(node.first)){
                    pq.add(new iPair(node.first, currentDistance));
                    res.set(node.first, currentDistance);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int n = 9; // Number of vertices
        ArrayList<ArrayList<iPair>> adj = new ArrayList<>(n);

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges (undirected graph with weights)
        adj.get(0).add(new iPair(1, 4));
        adj.get(0).add(new iPair(7, 8));
        adj.get(1).add(new iPair(0, 4));
        adj.get(1).add(new iPair(2, 8));
        adj.get(1).add(new iPair(7, 11));
        adj.get(2).add(new iPair(1, 8));
        adj.get(2).add(new iPair(3, 7));
        adj.get(2).add(new iPair(8, 2));
        adj.get(2).add(new iPair(5, 4));
        adj.get(3).add(new iPair(2, 7));
        adj.get(3).add(new iPair(4, 9));
        adj.get(3).add(new iPair(5, 14));
        adj.get(4).add(new iPair(3, 9));
        adj.get(4).add(new iPair(5, 10));
        adj.get(5).add(new iPair(2, 4));
        adj.get(5).add(new iPair(3, 14));
        adj.get(5).add(new iPair(4, 10));
        adj.get(5).add(new iPair(6, 2));
        adj.get(6).add(new iPair(5, 2));
        adj.get(6).add(new iPair(7, 1));
        adj.get(6).add(new iPair(8, 6));
        adj.get(7).add(new iPair(0, 8));
        adj.get(7).add(new iPair(1, 11));
        adj.get(7).add(new iPair(6, 1));
        adj.get(7).add(new iPair(8, 7));
        adj.get(8).add(new iPair(2, 2));
        adj.get(8).add(new iPair(6, 6));
        adj.get(8).add(new iPair(7, 7));

        int src = 0; // Start from node 0

        DjikstraPriorityQueue dijkstra = new DjikstraPriorityQueue();
        ArrayList<Integer> shortestPaths = dijkstra.dijkstra(adj, src);

        // Print shortest distances from source
        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < shortestPaths.size(); i++) {
            System.out.println("Node " + i + " -> " + shortestPaths.get(i));
        }
    }
}
