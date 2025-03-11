package DataStructures.Graphs;

public class BipartiteGraphDFS {
    public boolean dfs(int[][] graph, int start, int[] colored, int parentColor){
        int n = graph.length;
        if(parentColor == 0){
            colored[start] = 1;
        }
        else if(parentColor == 1){
            colored[start] = 2;
        }
        else if(parentColor == 2){
            colored[start] = 1;
        }

        int[] neighbours = graph[start];
        boolean res = true;
        for(int i = 0; i < neighbours.length; i++){
            if(colored[neighbours[i]] == 0){
                if(!dfs(graph, neighbours[i], colored, colored[start])){
                    return false;
                }
            }
            else{
                //if already colored, check if same color present.
                if(colored[neighbours[i]] == colored[start]){
                    return false;
                }
            }
        }
        //If all passed then return true
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colored = new int[n];
        boolean res = true;
        for(int i = 0; i < n; i++){
            if(colored[i] == 0){
                res = res && dfs(graph, i, colored, 0);
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
