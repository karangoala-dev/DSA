package DataStructures.Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {
    public void reverse(int[][] board){
        for(int i = 0; i < board.length / 2; i++){
            int[] temp = board[i];
            board[i] = board[board.length - 1 - i];
            board[board.length - 1 - i] = temp;
        }
    }
    public int[] positionToCorrdinates(int pos, int n){
        int[] res = new int[2];
        res[0] = (pos-1) / n;
        res[1] = (pos-1) % n;
        if(res[0] % 2 != 0){
            res[1] = n - 1 - res[1];
        }
        return res;
    }
    public int snakesAndLadders(int[][] board) {
        //reverse is done to make rows like (n -1 -> 0) and column remain same as usual, since square 1 is at bottom left corner
        reverse(board);
        int n = board.length;
        Queue<int[]> q = new LinkedList<>();
        //queue contains [squareNo, noOfMovesSoFar]
        q.add(new int[]{1, 0});
        HashSet<Integer> set = new HashSet<>();
        while(!q.isEmpty()){
            int[] currentSquare = q.poll();
//            int[] rc = positionToCorrdinates(currentSquare[0], n);
            for(int i = 1; i <= 6; i++){
                int nextSquare = currentSquare[0] + i;
                int[] nrc = positionToCorrdinates(nextSquare, n);
                if(board[nrc[0]][nrc[1]] != -1){
                    //Means we got a ladder or snake
                    nextSquare = board[nrc[0]][nrc[1]];
                }

                if(nextSquare == n * n){
                    return currentSquare[1] + 1;
                }
                if(!set.contains(nextSquare)){
                    set.add(nextSquare);
                    q.add(new int[]{nextSquare, currentSquare[1] + 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
