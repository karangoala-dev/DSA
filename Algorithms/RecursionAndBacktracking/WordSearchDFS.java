package Algorithms.RecursionAndBacktracking;

public class WordSearchDFS {
    public boolean helperDFS(char[][] board, String word, int ind, int r, int c, int[][] pathVisited){
        boolean result;
        if(ind == word.length() - 1){
            //special handling for last index
            if(word.charAt(ind) == board[r][c]){
                return true;
            }
            return false;
        }
        if(board[r][c] != word.charAt(ind)){
            return false;
        }
        else{
            result = true;
        }

        int n = board.length, m = board[0].length;
        pathVisited[r][c] = 1;
        int[] row = {0, -1, 0, 1};
        int[] col = {-1, 0, 1, 0};
        boolean neighboursConnect = false;
        for(int i = 0; i < 4; i++){
            int nR = r + row[i];
            int nC = c + col[i];
            if(nR >= 0 && nC >= 0 && nR < n && nC < m && pathVisited[nR][nC] == 0 && word.charAt(ind + 1) == board[nR][nC]){
                neighboursConnect = neighboursConnect || helperDFS(board, word, ind + 1, nR, nC, pathVisited);
            }
        }
        pathVisited[r][c] = 0;

        return neighboursConnect && result;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        int[][] pathVisited = new int[n][m];
        boolean accumulate = false;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == word.charAt(0)){
                    accumulate = accumulate || helperDFS(board, word, 0, i, j, pathVisited);
                }
            }
        }
        return accumulate;
    }
    public static void main(String[] args) {

    }
}
