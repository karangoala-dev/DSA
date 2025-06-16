package Revision;

public class NumberOfIslands {
    public void dfs(char[][] grid, int[][] vis, int r, int c){
        int n = grid.length, m = grid[0].length;
        int[] rows = {0, -1, 0, 1};
        int[] cols = {-1, 0, 1, 0};
        for(int i = 0; i < 4; i++){
            int nR = r + rows[i];
            int nC = c + cols[i];
            if(nR >= 0 && nC >= 0 && nR < n && nC < m && grid[nR][nC] == '1' && vis[nR][nC] == 0){
                vis[nR][nC] = 1;
                dfs(grid, vis, nR, nC);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 & grid[i][j] == '1'){
                    count++;
                    dfs(grid, vis, i, j);
                }
            }
        }
        return count;
    }
    public static void main(String[] args){

    }
}
