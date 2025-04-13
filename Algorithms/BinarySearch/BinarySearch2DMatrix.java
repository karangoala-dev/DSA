package Algorithms.BinarySearch;

public class BinarySearch2DMatrix {
    //Approach #1 TC: O(n log(m))
    public boolean binarySearch(int[] arr, int target){
        int l = 0, h = arr.length - 1;
        while(l <= h){
            int mid = (l + (h - l)/2);
            if(arr[mid] == target){
                return true;
            }

            if(target < arr[mid]){
                //go left
                h = mid - 1;
            }
            else{
                //go right
                l = mid + 1;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;

        //for all rows
        for(int i = 0; i < n; i++){
            if(matrix[i][0] <= target && matrix[i][m - 1] >= target){
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }

    //Approach #2: TC: O(log(n*m))

    public static void main(String[] args) {

    }
}
