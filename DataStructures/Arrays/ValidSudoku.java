package DataStructures.Arrays;

public class ValidSudoku {
    public boolean isValid(char[][] board, int r, int c, char num){
        for(int i = 0; i < 9; i++){
            if(board[i][c] == num && i != r){
                return false;
            }
            if(board[r][i] == num && i != c){
                return false;
            }

            int startRow = (r / 3) * 3;
            int startCol = (c / 3) * 3;
            if(board[startRow + (i / 3)][startCol + (i % 3)] == num && (startRow + (i / 3)) != r && (startRow + (i % 3)) != c){
                return false;
            }
        }
        return true;
    }
    public boolean helper(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] != '.'){
                    if(!isValid(board, i, j, board[i][j])){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        return helper(board);
    }
    public static void main(String[] args) {
        ValidSudoku validSudoku = new ValidSudoku();
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(validSudoku.isValidSudoku(board));
    }
}
