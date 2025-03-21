package DataStructures.Graphs;

public class SurroundedRegions_Optimised {
    public void dfs(char[][] board, int[][] visited, int sr, int sc){
        int n = board.length, m = board[0].length;
        board[sr][sc] = '#';
        visited[sr][sc] = 1;
        int[] row = {0, -1, 0, 1};
        int[] col = {-1, 0, 1, 0};
        for(int i = 0; i < 4; i++){
            int nRow = sr + row[i];
            int nCol = sc + col[i];
            if(nRow < n && nRow >= 0 && nCol >= 0 && nCol < m && visited[nRow][nCol] == 0 && board[nRow][nCol] == 'O'){
                dfs(board, visited, nRow, nCol);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        int[][] visited = new int[n][m];
        for(int i = 0; i < m; i++){
            if(board[0][i] == 'O' && visited[0][i] == 0){
                dfs(board, visited, 0, i);
            }
            if(board[n - 1][i] == 'O' && visited[n - 1][i] == 0){
                dfs(board, visited, n - 1, i);
            }
        }
        for(int i = 0; i < n; i++){
            if(board[i][0] == 'O' && visited[i][0] == 0){
                dfs(board, visited, i, 0);
            }
            if(board[i][m - 1] == 'O' && visited[i][m - 1] == 0){
                dfs(board, visited, i, m - 1);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    public static void main(String[] args) {

    }
}
