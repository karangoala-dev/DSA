package Algorithms.BinarySearch;

public class BinarySearch2DMatrix_2 {
    //HERE matrix is sorted horizontally, and vertically, it cannot be flattened into a 1D matrix

    public boolean searchMatrix(int[][] matrix, int target) {
        //start from bottom left cell
        //if target < current cell value, row--
        //else if target > current cell value, col++
        int n = matrix.length, m = matrix[0].length;
        int row = n - 1, col = 0;

        while(row >= 0 && col < m){
            if(target == matrix[row][col]){
                return true;
            }

            if(target < matrix[row][col]){
                row--;
            }
            else {
                col++;
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
