package DataStructures.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int node;
    int prev;

    Node(int n, int p) {
        this.node = n;
        this.prev = p;
    }
}

public class BfsCycleDetectionUndirectedGraph {
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        int[] visited = new int[n];
        for (int startNode = 0; startNode < n; startNode++) {
            if (visited[startNode] == 0) {
                if (bfs(adj, visited, startNode) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean bfs(ArrayList<ArrayList<Integer>> adj, int[] visited, int start) {
        visited[start] = 1;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, -1));
        while (!q.isEmpty()) {
            Node current = q.poll();
            ArrayList<Integer> neighbours = adj.get(current.node);
            for (int i = 0; i < neighbours.size(); i++) {
                if (visited[neighbours.get(i)] != 0 && neighbours.get(i) != current.prev) {
                    return true;
                }

                if (visited[neighbours.get(i)] == 0 && neighbours.get(i) != current.prev) {
                    q.add(new Node(neighbours.get(i), current.node));
                    visited[neighbours.get(i)] = 1;
                }
            }
        }
        return false;
    }
}
