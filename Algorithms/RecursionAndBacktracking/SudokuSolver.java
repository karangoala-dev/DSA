package Algorithms.RecursionAndBacktracking;

/*
 * ✅ Sudoku Validity Rules:
 * 1. Each row must contain the digits 1–9 without repetition.
 * 2. Each column must contain the digits 1–9 without repetition.
 * 3. Each of the 9 sub-boxes (3x3) must contain the digits 1–9 without repetition.
 */

public class SudokuSolver {
    //this fn verifies if the char c at pos (row, col) is valid or not
    public boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i <= 9; i++){
            // if any char in same row is same as c then return false
            if(board[row][i] == c){
                return false;
            }
            // if any char in same col is same as c then return false
            if(board[i][col] == c){
                return false;
            }
            // if any char in same sub-square is same as c then return false
            //            row / 3 → gives you **which block** you're in (0, 1, 2)
            //            (row / 3) * 3 → gives the **starting row** of that block (0, 3, 6)
            //Similarly for column
            int startRow = (row / 3) * 3;
            int startCol = (col / 3) * 3;
            if(board[startRow + i / 3][startCol + i % 3] == c){
                return false;
            }
        }
        return true;
    }
    //this fn is called recursively and returns true if any combination is valid
    public boolean helper(char[][] board){
        int n = board.length, m = board[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                //if cell is empty
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(isValid(board, i, j, c)){
                            //then place the character at that cell and recurse further
                            board[i][j] = c;
                            if(helper(board)){
                                return true;
                            }
                            //if not correct solution then backtrack remove the character and mark it as blank
                            board[i][j] = '.';
                        }
                    }
                    //we reached here means no combination satisfied for cell (i,j), no need to check further, so return false.
                    return false;
                }
            }
        }
        //if we reach here means no empty cells in entire board, so return true
        return true;
    }
    public void solveSudoku(char[][] board) {
        helper(board);
    }

    public static void main(String[] args) {

    }
}
