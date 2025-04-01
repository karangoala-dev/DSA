package DataStructures.Graphs;

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
    public int snakesAndLadders(int[][] board) {
        reverse(board);
        int n = board.length;
        Queue<Integer> q = new LinkedList<>();

        return -1;
    }

    public static void main(String[] args) {

    }
}
