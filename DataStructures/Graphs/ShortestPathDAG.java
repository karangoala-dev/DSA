package DataStructures.Graphs;

import java.util.ArrayList;

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
    //Edges are like [i,j,k] -> i and j are nodes like i->j and k is the weight
    public int[] shortestPath(int n, int E, int[][] edges) {
        int dist[] = new int[n];
        int indegree[] = new int[n];

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        //Create indegree array and adjacency list
        for(int[] curr: edges){
            int i = curr[0], j = curr[1], w = curr[2];
            indegree[j]++;
            adj.get(i).add(new Pair(j, w));
        }
        return dist;
    }
    public static void main(String[] args) {

    }
}
