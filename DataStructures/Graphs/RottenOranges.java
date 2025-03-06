package DataStructures.Graphs;

import java.util.LinkedList;
import java.util.Queue;

class Entity{
    int r;
    int c;
    int t;
    Entity(int _r, int _c, int _t){
        this.r = _r;
        this.c = _c;
        this.t = _t;
    }
}

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] visited = new int[n][m];
        Queue<Entity> q = new LinkedList<>();
        int totalFresh = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.add(new Entity(i, j, 0));
                    visited[i][j] = 2;
                }
                else if(grid[i][j] == 1){
                    totalFresh++;
                }
            }
        }

        int[] row = {0, -1, 0, 1};
        int[] col = {-1, 0, 1, 0};
        int time = 0;
        while(!q.isEmpty()){
            Entity curr = q.poll();
            for(int i = 0; i < 4; i++){
                int nRow = curr.r + row[i];
                int nCol = curr.c + col[i];
                time = Math.max(time, curr.t);
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && visited[nRow][nCol] == 0 && grid[nRow][nCol] == 1){
                    visited[nRow][nCol] = 2;
                    totalFresh--;
                    q.add(new Entity(nRow, nCol, curr.t + 1));
                }
            }
        }
        if(totalFresh != 0){
            return -1;
        }

        return time;
    }
    public static void main(String[] args) {

    }
}
