package DataStructures.Graphs;

public class ShortestPathWithObstacleElimination {
    private static class Triad{
        int r;
        int c;
        int k;
        Triad(int _r, int _c, int _k){
            this.r = _r;
            this.c = _c;
            this.k = _k;
        }
    }

    public int shortestPath(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int[] row = {0, -1, 0, 1};
        int[] col = {-1, 0, 1, 0};

    }
    public static void main(String[] args) {

    }
}
