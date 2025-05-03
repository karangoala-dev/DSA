package DataStructures.Graphs;

import java.util.*;

public class MinimumPathSum {
    private static class Node{
        int r;
        int c;
        int sum;

        Node(int _r, int _c, int _s){
            this.r = _r;
            this.c = _c;
            this.sum = _s;
        }
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        PriorityQueue<Node> q = new PriorityQueue<>((n1, n2) -> n1.sum - n2.sum);
        q.add(new Node(0,0,grid[0][0]));
        int[][] visited = new int[n][m];
        int res = Integer.MAX_VALUE;
        int[] row = {0, 1};
        int[] col = {1, 0};

        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.r == n - 1 && curr.c == m - 1){
                //if we reached destination, consider for minimum res
                return curr.sum;
            }
            for(int i = 0; i < 2; i++){
                int nR = curr.r + row[i];
                int nC = curr.c + col[i];
                if(nR >= 0 && nC >= 0 && nR < n && nC < m && visited[nR][nC] == 0){
                    q.add(new Node(nR, nC, curr.sum + grid[nR][nC]));
                    visited[nR][nC] = 1;
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
