package DataStructures.Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AllPathFromSourceToTarget {
    private List<List<Integer>> res = new ArrayList<>();
    public void dfs(int[][] graph, HashSet<Integer> visited, List<Integer> curr, int node){
        int n = graph.length;
        curr.add(node);
        visited.add(node);
        if(node == n - 1){
            res.add(new ArrayList<>(curr));
            visited.remove(node);
            curr.remove(curr.size() - 1);
            return;
        }

        int[] neis = graph[node];
        for(int nei: neis){
            if(!visited.contains(nei)){
                dfs(graph, visited, curr, nei);
            }
        }
        visited.remove(node);
        curr.remove(curr.size() - 1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph, new HashSet<>(), new ArrayList<>(), 0);
        return res;
    }
    public static void main(String[] args) {

    }
}
