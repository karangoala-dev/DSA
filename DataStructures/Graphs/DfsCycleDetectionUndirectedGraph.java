package DataStructures.Graphs;

import java.util.ArrayList;

public class DfsCycleDetectionUndirectedGraph {
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        int[] visited = new int[n];

        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                if(dfs(i, -1, adj, visited) == true){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, int[] visited){
        visited[node] = 1;
        ArrayList<Integer> neighbours = adj.get(node);
        for(int num: neighbours){
            if(visited[num] == 0){
                // visited[num] = 1;
                visited[num] = 1;
                if(dfs(num, node, adj, visited)){
                    return true;
                }
            }
            else if(num != parent){
                // System.out.println("Hello3" + node);
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        testGraph(5, new int[][]{{3, 0}, {4, 2}, {1, 2}}, "Test 1 (Acyclic Graph)"); // Expected: 0

        testGraph(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 0}}, "Test 2 (Cycle Present)"); // Expected: 1

        testGraph(6, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}}, "Test 3 (Acyclic Chain)"); // Expected: 0

        testGraph(4, new int[][]{{0, 1}, {1, 2}, {2, 0}}, "Test 4 (Triangle Cycle)"); // Expected: 1

        testGraph(7, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 1}, {5, 6}}, "Test 5 (Disconnected with a Cycle)"); // Expected: 1

        testGraph(4, new int[][]{{0, 1}, {1, 2}, {2, 3}}, "Test 6 (Simple Line Graph)"); // Expected: 0
    }

    public static void testGraph(int n, int[][] edges, String testName) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); // Since it's an undirected graph
        }

        DfsCycleDetectionUndirectedGraph obj = new DfsCycleDetectionUndirectedGraph();
        System.out.println(testName + " - Cycle present? " + (obj.isCyclic(adj) ? 1 : 0));
    }

}
