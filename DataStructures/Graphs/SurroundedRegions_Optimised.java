package DataStructures.Graphs;

public class SurroundedRegions_Optimised {
    //basic dfs fn to mark all connected O's as #
    public void dfs(char[][] board, int r, int c){
        int n = board.length, m = board[0].length;
        int[] row = {0, -1, 0, 1};
        int[] col = {-1, 0, 1, 0};
        for(int i = 0; i < 4; i++){
            int nR = row[i] + r;
            int nC = col[i] + c;
            if(nR >= 0 && nC >= 0 && nR < n && nC < m && board[nR][nC] == 'O'){
                board[nR][nC] = '#';
                dfs(board, nR, nC);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        //List of array where each arr is [r,c]
        List<int[]> boundaryOs = new ArrayList<>();
        //first row - last row
        for(int i = 0; i < m; i++){
            if(board[0][i] == 'O'){
                board[0][i] = '#';
                boundaryOs.add(new int[]{0,i});
            }
            if(board[n - 1][i] == 'O'){
                board[n - 1][i] = '#';
                boundaryOs.add(new int[]{n - 1,i});
            }
        }

        //first col - last col
        for(int i = 0; i < n; i++){
            if(board[i][0] == 'O'){
                board[i][0] = '#';
                boundaryOs.add(new int[]{i, 0});
            }
            if(board[i][m - 1] == 'O'){
                board[i][m - 1] = '#';
                boundaryOs.add(new int[]{i, m - 1});
            }
        }

        //for each boundary O, run a dfs
        for(int[] node : boundaryOs){
            dfs(board, node[0], node[1]);
        }

        //now only non-boundary connected O regions remain
        //so mark all as X
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

        //mark back all #'s as O
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
