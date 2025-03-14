package DataStructures.Graphs;

import java.util.ArrayList;
import java.util.Stack;

//This uses topological sort(any, BFS/DFS) to gather the result. Return array of minimum distance weight from 0. (What if source is dynamic?)
//Input: V = 4, E = 2, edges = [[0,1,2], [0,2,1]]
//Output: [0, 2, 1, -1]
class Pair{
    int v;
    int w;
    Pair(int _v, int _w){
        this.v = _v;
        this.w = _w;
    }
}
public class ShortestPathDAG {
    Stack<Integer> st = new Stack<>();
    public void dfsTopoSort(ArrayList<ArrayList<Pair>> adj, int[] visited, int node){
        visited[node] = 1;
        ArrayList<Pair> neighbours = adj.get(node);
        for(Pair current: neighbours){
            if(visited[current.v] == 0){
                dfsTopoSort(adj, visited, current.v);
            }
        }
        st.push(node);
    }

    //Edges are like [i,j,k] -> i and j are nodes like i->j and k is the weight
    public int[] shortestPath(int n, int E, int[][] edges) {
        int dist[] = new int[n];
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        //Create adjacency list
        for(int[] curr: edges){
            int i = curr[0], j = curr[1], w = curr[2];
            adj.get(i).add(new Pair(j, w));
        }

        int[] visited = new int[n];
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                dfsTopoSort(adj, visited, i);
            }
        }



        return dist;
    }
    public static void main(String[] args) {

    }
}
