package DataStructures.Graphs;

import java.util.ArrayList;

public class SurroundedRegions {
    private static class Pair{
        int r;
        int c;
        Pair(int _r, int _c){
            this.r = _r;
            this.c = _c;
        }
    }
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        int[][] visited = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] == 0 && board[i][j] == 'O'){
                    ArrayList<Pair> dummy = new ArrayList<>();
                    boolean[] isBoundary = {false};
                    dfs(i, j, board, visited, dummy, isBoundary);
                    System.out.println("Calling " + i + " " + j);
                    if(!isBoundary[0]){
                        System.out.println("hello");
                        for(Pair p: dummy){
                            board[p.r][p.c] = 'X';
                        }
                    }
                }
            }
        }
    }
    public void dfs(int sr, int sc, char[][] board, int[][] visited, ArrayList<Pair> dummy, boolean[] isBoundary){
        int n = board.length, m = board[0].length;
        visited[sr][sc] = 1;
        if(sr == 0 || sr == n - 1 || sc == 0 || sc == m - 1){
            isBoundary[0] = true;
        }
        int[] row = {0, -1, 0, 1};
        int[] col = {-1, 0, 1, 0};
        dummy.add(new Pair(sr, sc));
        for(int i = 0; i < 4; i++){
            int nRow = sr + row[i];
            int nCol = sc + col[i];
            if(nRow < n && nRow >= 0 && nCol >= 0 && nCol < m && visited[nRow][nCol] == 0 && board[nRow][nCol] == 'O'){
                // visited[nRow][nCol] = 1;
                dfs(nRow, nCol, board, visited, dummy, isBoundary);
            }
        }
    }

    public static void main(String[] args) {

    }
}
