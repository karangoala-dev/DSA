package Revision;

import java.util.*;

public class NQueens {
    HashSet<Integer> col = new HashSet<>();
    HashSet<Integer> posDiag = new HashSet<>();
    HashSet<Integer> negDiag = new HashSet<>();

    public void helper(List<List<String>> res, List<String> currBoard, int n, int row){
        if(row == n){
            //we reached last row, so add this board to res and return
            res.add(new ArrayList<>(currBoard));
            return;
        }
        //now for i-th row, check if we can place a queen at each column and then backtrack and try for next column
        for(int i = 0; i < n; i++){
            if(col.contains(i) || posDiag.contains(row + i) || negDiag.contains(row - i)){
                continue;
            }
            StringBuilder sb = new StringBuilder(currBoard.get(row));
            sb.setCharAt(i, 'Q');
            currBoard.set(row, sb.toString());
            col.add(i);
            posDiag.add(row + i);
            negDiag.add(row - i);
            helper(res, currBoard, n, row + 1);
            //backtrack
            sb.setCharAt(i, '.');
            col.remove(i);
            posDiag.remove(row + i);
            negDiag.remove(row - i);
            currBoard.set(row, sb.toString());
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        List<String> board = new ArrayList<>();
        for(int i = 0; i < n; i++){
            sb.append('.');
        }
        for(int i = 0; i < n; i++){
            board.add(sb.toString());
        }
        helper(res, board, n, 0);
        return res;
    }
    public static void main(String[] args) {

    }
}
