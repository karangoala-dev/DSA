package Algorithms.DynamicProgramming;

public class CountSubmatricesOfAll1s {
    //Very unintuitive approach
    public int numSubmat(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        //this is the histogram to be generated
        int[][] height = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0){
                    height[i][j] = mat[i][j];
                }
                else {
                    height[i][j] = mat[i][j] == 0 ? 0 : height[i - 1][j] + 1;
                }
            }
        }

        //in the historgram matrix, compute
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                //for each cell, we wanna see how many sub-matrices can be formed with just 1s when current cell is the bottom right-most cell of that matrix
                int min = Integer.MAX_VALUE;
                for(int k = j; k >= 0 && min > 0; k--){
                    min = Math.min(min, height[i][k]);
                    res += min;
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
