package Algorithms.RecursionAndBacktracking;

import java.util.*;

public class NQueens {
    List<List<String>> res = new ArrayList<>();
    HashSet<Integer> columns = new HashSet<>();
    HashSet<Integer> positiveDiag = new HashSet<>();
    HashSet<Integer> negativeDiag = new HashSet<>();

    //This fn will be called for each row, this problem can also be done column wise as drawn in notebook
    public void helper(List<String> board, int row){
        if(row == board.size()){
            //means we reached last row
            res.add(new ArrayList<>(board));
            return;
        }

        for(int col = 0; col < board.size(); col++){
            if(columns.contains(col) || positiveDiag.contains(row + col) || negativeDiag.contains(row - col)){
                //since if we add queen here, queen will be attacked
                continue;
            }

            //add this entry to the sets
            columns.add(col);
            positiveDiag.add(row + col);
            negativeDiag.add(row - col);
            //mark the queen on the board
            String initial = board.get(row);
            StringBuilder sb = new StringBuilder(board.get(row));
            sb.setCharAt(col, 'Q');
            board.set(row, sb.toString());
            //recurse
            helper(board, row + 1);

            //backtrack
            columns.remove(col);
            positiveDiag.remove(row + col);
            negativeDiag.remove(row - col);
            board.set(row, initial);
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>(n);
        String blankRow = "";
        for(int i = 0; i < n; i++){
            blankRow += ".";
        }
        for(int i = 0; i < n; i++){
            board.add(blankRow);
        }

        helper(board, 0);
        return res;
    }
    public static void main(String[] args) {

    }
}
