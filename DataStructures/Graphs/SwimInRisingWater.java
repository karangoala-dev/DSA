package DataStructures.Graphs;

import java.util.*;

public class SwimInRisingWater {
    private static class Node{
        int r;
        int c;
        int t;
        Node(int _r, int _c, int _t){
            this.r = _r;
            this.c = _c;
            this.t = _t;
        }
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)->o1.t-o2.t);
        int[][] height = new int[n][m];
        int[] row = {0, -1, 0, 1};
        int[] col = {-1, 0, 1, 0};
        for(int i = 0; i < n; i++){
            Arrays.fill(height[i], Integer.MAX_VALUE);
        }
        height[0][0] = grid[0][0];
        pq.add(new Node(0, 0, grid[0][0]));

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            for(int i = 0; i < 4; i++){
                int nRow = curr.r + row[i];
                int nCol = curr.c + col[i];
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m){
                    int maxHeight = Math.max(curr.t, grid[nRow][nCol]);
                    if(maxHeight < height[nRow][nCol]){
                        pq.add(new Node(nRow, nCol, maxHeight));
                        height[nRow][nCol] = maxHeight;
                    }
                }
            }
        }
        return height[n - 1][m - 1];
    }

    public static void main(String[] args) {

    }
}
