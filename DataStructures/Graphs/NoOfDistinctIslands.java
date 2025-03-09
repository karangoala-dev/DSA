package DataStructures.Graphs;

import java.util.ArrayList;
import java.util.HashSet;

class IslandNode{
    int r;
    int c;
    IslandNode(int _r, int _c){
        this.r = _r;
        this.c = _c;
    }

    public String toString(){
        return Integer.toString(this.r) + " " + Integer.toString(this.c);
    }
}

public class NoOfDistinctIslands {
    void dfs(int[][] grid, int[][] visited, int r0, int c0, HashSet<ArrayList<String>> set){

    }

    int countDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        HashSet<ArrayList<String>> set = new HashSet<>();
        int[][] visited = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] == 0 && grid[i][j] == 1){
                    dfs(grid, visited, i, j, set);
                }
            }
        }
    }
    public static void main(String[] args) {

    }
}
