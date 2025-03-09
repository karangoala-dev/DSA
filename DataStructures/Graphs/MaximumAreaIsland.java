package DataStructures.Graphs;

public class MaximumAreaIsland {
    public void dfs(int r, int c, int[][] visited, int[][] grid, int[] area){
        int n = grid.length, m = grid[0].length;
        int[] row = {0, -1, 0, 1};
        int[] col = {-1, 0, 1, 0};
        visited[r][c] = 1;
        for(int i = 0; i < 4; i++){
            int nRow = r + row[i];
            int nCol = c + col[i];
            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && visited[nRow][nCol] == 0 && grid[nRow][nCol] == 1){
                area[0] += 1;
                dfs(nRow, nCol, visited, grid, area);
            }
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        int n = grid.length, m = grid[0].length;
        int[][] visited = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] == 0 && grid[i][j] == 1){
                    int[] curr = {1};
                    dfs(i, j, visited, grid, curr);
                    res = Math.max(res, curr[0]);
                }
            }
        }

        return res;
    }
}
