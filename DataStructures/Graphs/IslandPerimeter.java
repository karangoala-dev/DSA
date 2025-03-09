package DataStructures.Graphs;

public class IslandPerimeter {
    public void dfs(int r, int c, int[] p, int[][] grid, int[][] visited){
        int[] row = {0, -1, 0, 1};
        int[] col = {-1, 0, 1, 0};
        int n = grid.length, m = grid[0].length;
        visited[r][c] = 1;
        //Total 4 scenarios for any cell
        //If adjacent scenario has a 1, do dfs, else if it is a 0 or out of bounds then add 1 to perimeter.
        for(int i = 0; i < 4; i++){
            int nRow = r + row[i];
            int nCol = c + col[i];

            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && visited[nRow][nCol] == 0 && grid[nRow][nCol] == 1){
                dfs(nRow, nCol, p, grid, visited);
            }
            else if(nRow < 0 || nCol < 0 || nRow >= n || nCol >= m || grid[nRow][nCol] == 0){
                p[0] += 1;
            }
        }
    }
    public int islandPerimeter(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] perimeter = {0};
        int[][] visited = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){

                    dfs(i, j, perimeter, grid, visited);
                }
            }
        }
        return perimeter[0];
    }

    public static void main(String[] args) {

    }
}
