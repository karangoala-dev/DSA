package DataStructures.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathWithObstacleElimination {
    private static class Quad{
        int r;
        int c;
        int k;
        int moves;
        Quad(int _r, int _c, int _k, int _m){
            this.r = _r;
            this.c = _c;
            this.k = _k;
            this.moves = _m;
        }
    }

    public int shortestPath(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int[][][] visited = new int[n][m][k + 1];
        int[] row = {0, -1, 0, 1};
        int[] col = {-1, 0, 1, 0};
        Queue<Quad> q = new LinkedList<>();
        q.add(new Quad(0, 0, k, 0));
        visited[0][0][k] = 1;

        while(!q.isEmpty()){
            Quad curr = q.poll();
            if(curr.r == n - 1 && curr.c == m - 1){
                //we reached destination
                return curr.moves;
            }
            for(int i = 0; i < 4; i++){
                int nr = row[i] + curr.r;
                int nc = col[i] + curr.c;

                if(nr >= 0 && nr < n && nc >= 0 && nc < m && (grid[nr][nc] == 0 || curr.k > 0)){
                    int neighK = grid[nr][nc] == 1 ? curr.k - 1 : curr.k;
                    if(visited[nr][nc][neighK] == 0){
                        visited[nr][nc][neighK] = 1;
                        q.add(new Quad(nr, nc, neighK, curr.moves + 1));
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}
