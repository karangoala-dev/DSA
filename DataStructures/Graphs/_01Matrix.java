package DataStructures.Graphs;

import java.util.*;

class Cell{
    int r;
    int c;
    int d;

    Cell(int _r, int _c, int _d){
        this.r = _r;
        this.c = _c;
        this.d = _d;
    }
}

public class _01Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] res = new int[n][m];

        Queue<Cell> q = new LinkedList<>();
        int[][] visited = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    q.add(new Cell(i, j, 0));
                    visited[i][j] = 1;
                }
            }
        }
        int[] row = {0, -1, 0, 1};
        int[] col = {-1, 0, 1, 0};
        while(!q.isEmpty()){
            Cell current = q.poll();
            for(int i = 0; i < 4; i++){
                int nRow = current.r + row[i];
                int nCol = current.c + col[i];
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && visited[nRow][nCol] == 0 && mat[nRow][nCol] == 1){
                    res[nRow][nCol] = current.d + 1;
                    q.add(new Cell(nRow, nCol, current.d + 1));
                    visited[nRow][nCol] = 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
