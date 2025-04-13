package Algorithms.BinarySearch;

public class CountNegativeNos {
    public int countNegatives(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int r = n - 1, c = 0;
        int res = 0;

        while(r >= 0 && c < m){
            if(grid[r][c] < 0){
                //means all cols right of this is negative since grid is sorted
                res += m - c;
                //also go up, to the row above
                r--;
            }
            else{
                //means go right to find a smaller no which might be negative
                c++;
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
