package DataStructures.Graphs;

import java.util.*;

class Island{
    int r;
    int c;
    Island(int _r, int _c){
        this.r = _r;
        this.c = _c;
    }
}

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int res = 0;
        int n = grid.length, m = grid[0].length;
        int[][] visited = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    bfs(grid, i, j, visited);
                    res++;
                }
            }
        }
        return res;
    }

    public void bfs(char[][] grid, int r, int c, int[][] visited){
        visited[r][c] = 1;
        int n = grid.length, m = grid[0].length;
        Queue<Island> q = new LinkedList<>();
        q.add(new Island(r, c));
        int[] row = {0, -1, 0, 1};
        int[] col = {-1, 0, 1, 0};
        while(!q.isEmpty()){
            Island current = q.poll();
            for(int i = 0; i < 4; i++){
                int nRow = current.r + row[i];
                int nCol = current.c + col[i];
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && visited[nRow][nCol] == 0 && grid[nRow][nCol] == '1'){
                    visited[nRow][nCol] = 1;
                    q.add(new Island(nRow, nCol));
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
