package DataStructures.Graphs;

import java.util.ArrayList;
import java.util.HashSet;

public class NoOfDistinctIslands {
    void dfs(int[][] grid, int[][] visited, int r0, int c0, ArrayList<String> list, int r, int c){
        int n = grid.length, m = grid[0].length;
        list.add(toString(r-r0, c-c0));
        int[] row = {0, -1, 0, 1};
        int[] col = {-1, 0, 1, 0};
        for(int i = 0; i < 4; i++){
            int nRow = r + row[i];
            int nCol = c + col[i];
            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && visited[nRow][nCol] == 0 && grid[nRow][nCol] == 1){
                visited[nRow][nCol] = 1;
                dfs(grid, visited, r0, c0, list, nRow, nCol);
            }
        }
    }

    public String toString(int r, int c){
        return Integer.toString(r) + " " + Integer.toString(c);
    }

    int countDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        HashSet<ArrayList<String>> set = new HashSet<>();
        int[][] visited = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] == 0 && grid[i][j] == 1){
                    ArrayList<String> list = new ArrayList<>();
                    dfs(grid, visited, i, j, list, i, j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
    public static void main(String[] args) {

    }
}
