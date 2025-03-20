package DataStructures.Graphs;

import java.util.*;

class PrimTrio{
    int node;
    int dist;
    int parent;
    PrimTrio(int _n, int _d, int _p){
        this.node = _n;
        this.dist = _d;
        this.parent = _p;
    }
}

class PrimEdge{
    int u;
    int v;
    PrimEdge(int _u, int _v){
        this.u = _u;
        this.v = _v;
    }
}

public class PrimsAlgo_GetMST {
    static ArrayList<PrimEdge> spanningTree(int V, int E, List<List<int[]>> adj) {
        ArrayList<PrimEdge> edges = new ArrayList<>();
        PriorityQueue<PrimTrio> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        int[] visited= new int[V];
        int sum = 0;
        pq.add(new PrimTrio(0, 0, -1));

        while(!pq.isEmpty()){
            PrimTrio current = pq.poll();
            int node = current.node;
            int wt = current.dist;
            int parent = current.parent;

            if(visited[node] == 1){
                continue;
            }

            visited[node] = 1;
            sum += wt;
            if(parent != -1){
                edges.add(new PrimEdge(parent, node));
            }

            List<int[]> neighbours = adj.get(node);
            for(int i = 0; i < neighbours.size(); i++){
                int[] neighbourNode = neighbours.get(i);
                int nNode = neighbourNode[0];
                int nWt = neighbourNode[1];
                if(visited[nNode] == 0){
                    pq.add(new PrimTrio(nNode, nWt, node));
                }
            }
        }
        System.out.println("Sum of the MST is : " + sum);
        return edges;
    }

    static void addEdge(List<List<int[]>> adj, int u, int v, int w) {
        adj.get(u).add(new int[]{v, w});
        adj.get(v).add(new int[]{u, w}); // Since it's an undirected graph
    }
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int E = 6; // Number of edges

        // Adjacency list representation: adj[i] -> List of {neighbor, weight}
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges (undirected graph)
        addEdge(adj, 0, 1, 2);
        addEdge(adj, 0, 3, 6);
        addEdge(adj, 1, 2, 3);
        addEdge(adj, 1, 3, 8);
        addEdge(adj, 1, 4, 5);
        addEdge(adj, 2, 4, 7);

        // Call the spanningTree function
        ArrayList<PrimEdge> mst = spanningTree(V, E, adj);

        // Print the MST result
        System.out.println("Minimum Spanning Tree Edges:");
        for (PrimEdge edge : mst) {
            System.out.println(edge.u + " - " + edge.v);
        }
    }
}
