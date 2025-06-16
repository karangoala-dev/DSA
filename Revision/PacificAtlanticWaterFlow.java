package Revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    //in visited array
    //A = Atlantic
    //P = Pacific
    //B = Both
    //U = unvisited
    List<List<Integer>> res = new ArrayList<>();
    public void dfs(int[][] heights, char[][] visited, int r, int c, char ocean, int prevHeight){
        int n = heights.length, m = heights[0].length;
        int[] rows = {0, -1, 0, 1};
        int[] cols = {-1, 0, 1, 0};
        visited[r][c] = ocean;

        for(int i = 0; i < 4; i++){
            int nR = r + rows[i];
            int nC = c + cols[i];
            if(nR >= 0 && nC >= 0 && nR < n && nC < m && heights[nR][nC] >= prevHeight && visited[nR][nC] == 'U'){
                dfs(heights, visited, nR, nC, ocean, heights[nR][nC]);
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        char[][] pacific = new char[n][m];
        char[][] atlantic = new char[n][m];
        for(char[] curr: pacific){
            Arrays.fill(curr, 'U');
        }
        for(char[] curr: atlantic){
            Arrays.fill(curr, 'U');
        }

        //first for pacific-first row
        for(int i = 0; i < m; i++){
            if(pacific[0][i] == 'U'){
                dfs(heights, pacific, 0, i, 'P', heights[0][i]);
            }
        }
        //for pacific first column
        for(int i = 0; i < n; i++){
            if(pacific[i][0] == 'U'){
                dfs(heights, pacific, i, 0, 'P', heights[i][0]);
            }
        }

        //for atlantic-last row
        for(int i = 0; i < m; i++){
            if(atlantic[n - 1][i] == 'U'){
                dfs(heights, atlantic, n - 1, i, 'A', heights[n - 1][i]);
            }
        }
        //for atlantic last column
        for(int i = 0; i < n; i++){
            if(atlantic[i][m - 1] == 'U'){
                dfs(heights, atlantic, i, m - 1, 'A', heights[i][m - 1]);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(pacific[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(atlantic[i][j] + " ");
            }
            System.out.println();
        }

        //now accumulate result
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(pacific[i][j] == 'P' && atlantic[i][j] == 'A'){
                    res.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {
        PacificAtlanticWaterFlow pacificAtlanticWaterFlow = new PacificAtlanticWaterFlow();
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        System.out.println(pacificAtlanticWaterFlow.pacificAtlantic(heights));
    }
}
