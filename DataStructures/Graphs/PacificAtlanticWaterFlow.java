package DataStructures.Graphs;

import java.util.*;

public class PacificAtlanticWaterFlow {
    int n;
    int m;
    private class Pair{
        int r;
        int c;
        Pair(int _r, int _c){
            this.r = _r;
            this.c = _c;
        }

        @Override
        public boolean equals(Object p){
            if(!(p instanceof Pair)){
                return false;
            }
            return this.r == ((Pair) p).r && this.c == ((Pair) p).c ? true : false;
        }

        @Override
        public int hashCode(){
            return Objects.hash(this.r, this.c);
        }
    }

    public void dfs(Pair curr, Set<Pair> path, int[][] heights, int prevHeight){
        if(curr.r < 0 || curr.r >= n || curr.c < 0 || curr.c >= m || heights[curr.r][curr.c] < prevHeight || path.contains(curr)){
            return;
        }

        //if valid then mark it as a node in my path.
        path.add(curr);
        //Now traverse the neighbours in 4 Directions
        int[] row = {0, -1, 0, 1};
        int[] col = {-1, 0, 1, 0};
        for(int i = 0; i < 4; i++){
            int nRow = curr.r + row[i];
            int nCol = curr.c + col[i];
            dfs(new Pair(nRow, nCol), path, heights, heights[curr.r][curr.c]);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n = heights.length;
        m = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        Set<Pair> pacific = new HashSet<>();
        Set<Pair> atlantic = new HashSet<>();
        int n = heights.length, m = heights[0].length;

        //Go for each cell in top and bottom row
        for(int c = 0; c < m; c++){
            dfs(new Pair(0, c), pacific, heights, heights[0][c]);
            dfs(new Pair(n - 1, c), atlantic, heights, heights[n - 1][c]);
        }

        //Go for each cell in leftmost and rightmost columns
        for(int r = 0; r < n; r++){
            dfs(new Pair(r, 0), pacific, heights, heights[r][0]);
            dfs(new Pair(r, m - 1), atlantic, heights, heights[r][m - 1]);
        }

        //Now for each cell in the matrix, check if it is present in both set or not
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(pacific.contains(new Pair(i, j)) && atlantic.contains(new Pair(i, j))){
                    res.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
