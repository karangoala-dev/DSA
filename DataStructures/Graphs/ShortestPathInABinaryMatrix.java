package DataStructures.Graphs;

import java.util.*;

class MxCell{
    int r;
    int c;
    int d;

    MxCell(int _r, int _c, int _d){
        this.r = _r;
        this.c = _c;
        this.d = _d;
    }
}

public class ShortestPathInABinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1){
            return -1;
        }
        Queue<MxCell> q = new LinkedList<>();
        int[][] visited = new int[n][n];
        visited[0][0] = 1;
        int[] row = {0, -1, 0, 1, -1, -1, 1, 1};
        int[] col = {-1, 0, 1, 0, -1, 1, 1, -1};
        q.add(new MxCell(0,0,1));
        while(!q.isEmpty()){
            MxCell current = q.poll();
            if(current.r == n-1 && current.c == n-1){
                return current.d;
            }
            for(int i = 0; i < 8; i++){
                int nRow = current.r + row[i];
                int nCol = current.c + col[i];
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < n && grid[nRow][nCol] == 0 && visited[nRow][nCol] != 1){
                    q.add(new MxCell(nRow, nCol, current.d + 1));
                    visited[nRow][nCol] = 1;
                }
            }
        }
        return -1;
    }
}
